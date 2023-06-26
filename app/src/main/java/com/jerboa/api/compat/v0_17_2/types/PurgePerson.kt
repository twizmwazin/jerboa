package com.jerboa.api.compat.v0_17_2.types
data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
    val auth: String,
)
