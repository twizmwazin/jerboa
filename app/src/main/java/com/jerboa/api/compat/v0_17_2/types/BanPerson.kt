package com.jerboa.api.compat.v0_17_2.types
data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_data: Boolean?,
    val reason: String?,
    val expires: Int?,
    val auth: String,
)
