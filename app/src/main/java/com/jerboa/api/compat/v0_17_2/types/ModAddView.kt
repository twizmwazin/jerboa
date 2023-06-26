package com.jerboa.api.compat.v0_17_2.types
data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val modded_person: Person,
)
