package com.jerboa.api.types
 data class ModBan(
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String?,
    val banned: Boolean,
    val expires: String?,
    val when_: String,
)
