package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
    val auth: String,
)
