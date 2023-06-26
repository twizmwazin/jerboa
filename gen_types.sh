#!/bin/bash

INPUT_DIR=$1
OUTPUT_DIR=$2
PKG_NAME=$3

mkdir -p $OUTPUT_DIR

cp $INPUT_DIR*.ts $OUTPUT_DIR
pushd $OUTPUT_DIR

for file in *.ts; do mv "$file" "${file%.ts}.kt"; done

for file in *.kt; do
  echo "Processing $file"

  # Remove comments
  sed -i '/^\/\//d' $file
  # Add package name
  sed -i "1s/^/package $PKG_NAME\n/" $file
  # Imports
#  sed -i -r "s/import type \{ ([^ ]*) \} from \"\.\/([^\"]*)\";/import $PKG_NAME.\1/g" $file
  sed -i -r "s/import type \{ ([^ ]*) \} from \"\.\/([^\"]*)\";//g" $file
  # Data class names
  sed -i 's/export interface \(.*\) {/data class \1(/' $file
  # Data class closing
  sed -i 's/^}$/)/' $file
  # Data class fields
  sed -i -E 's/^\s*(\w+)([?]?): (\w+)(<\w+>)?(\[\])?;/  val \1: \3\4\5\2,/' "$file"
  # Type aliases
  sed -i -E 's/^export type (\w+) = null;/typealias \1 = Nothing?/' $file
  sed -i -E 's/^export type (\w+) = (\w+);/typealias \1 = \2/' $file
  # Enum types
  cat $file | awk -F' = ' '
  /^export type .* = ".*" \| ".*";$/ {
      gsub(/export type /, "", $1)
      printf("enum class %s {\n", $1)
      gsub(/"|;/, "", $2)
      n = split($2, a, " \\| ")
      for(i = 1; i <= n; i++) {
          printf("    @SerializedName(\"%s\")\n    %s,\n", a[i], a[i])
      }
      print "}"
      next
  }
  { print }
  ' > $file.tmp
  rm $file
  mv $file.tmp $file

  # Covert primitive types
  sed -i 's/boolean/Boolean/g' $file
  sed -i 's/string/String/g' $file
  sed -i 's/Array/List/g' $file
  sed -i 's/\([^[:alnum:]]\) \([^[:space:]]*\)\[\]/\1 List<\2>/g' $file
  sed -i 's/number/Int/g' $file

  # Constants
  sed -i -E 's/export const ([A-Za-z_][A-Za-z0-9_]*) = ("[^"]*");/val \1 = \2/g' $file



  python_script=$(cat <<EOF
import sys
import re

# Read the TypeScript enum from stdin
input_data = sys.stdin.read()

# Extract the enum name
enum_name_match = re.search(r"enum\s+(\w+)", input_data)
if enum_name_match:
    enum_name = enum_name_match.group(1)
else:
    enum_name = "EnumName"  # Default enum name if not found

# Remove line breaks and whitespace from the enum declaration
enum_declaration = re.search(r"(enum|type)\s+[\w\s]+={0,1}", input_data)
if enum_declaration:
    enum_declaration = enum_declaration.group(0)
    enum_declaration = re.sub(r"[\r\n\s]+", " ", enum_declaration)
else:
    enum_declaration = f"enum {enum_name}"

# Remove the enum declaration and extract the enum content
enum_content = re.sub(r".*?(?=enum|\n\n)", "", input_data, flags=re.DOTALL)
enum_content = enum_content.strip()

# Extract enum values
values = re.findall(r'"\w+"', enum_content)

# Generate modified enum
modified_enum = f"enum class {enum_name} {{\n"
for value in values:
    value = value.strip('"')
    serialized_name = value[0].lower() + value[1:]
    modified_enum += f'    @SerializedName("{serialized_name}")\n    {value},\n'
modified_enum += "}"

# Replace the original enum content with the modified enum
output_data = input_data.replace(enum_content, modified_enum)

# Output the modified data to stdout
print(output_data)
EOF
  )

  if grep -q -E "export type" $file; then
    echo "Found enum type"
    cat $file | python -c "$python_script" > $file.tmp
    rm $file
    mv $file.tmp $file
  fi


 python_script_2=$(cat <<EOF
import re
import sys

def convert_enum(enum_declaration):
    # Replace "export enum" with "enum class"
    enum_declaration = enum_declaration.replace("export enum", "enum class")

    return enum_declaration


def convert_enums(source_content):
    # Find all enum declarations
    enum_declarations = re.findall(r'export enum .*?}', source_content, re.DOTALL)

    # Convert each enum and replace in the content
    modified_content = source_content
    for enum_declaration in enum_declarations:
        kotlin_enum_declaration = convert_enum(enum_declaration)
        modified_content = modified_content.replace(enum_declaration, kotlin_enum_declaration)

    return modified_content


# Read the TypeScript source content from stdin
source_content = sys.stdin.read()

# Convert the enums and emit the modified content to stdout
modified_content = convert_enums(source_content)
sys.stdout.write(modified_content)
EOF
  )
  if grep -q -E "export enum" $file; then
    echo "Found enum type 2"
    cat $file | python -c "$python_script" > $file.tmp
    rm $file
    mv $file.tmp $file
  fi






done



