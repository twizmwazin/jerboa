package com.jerboa.api.compat.v0_17_2.types
data class AdminPurgePerson(
    val id: Int,
    val admin_person_id: PersonId,
    val reason: String?,
    val when_: String,
)
