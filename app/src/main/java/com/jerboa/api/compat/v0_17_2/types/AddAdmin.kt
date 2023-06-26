package com.jerboa.api.compat.v0_17_2.types

data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
    val auth: String,
)
