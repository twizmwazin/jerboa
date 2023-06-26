package com.jerboa.api.types
 data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
    val auth: String,
)
