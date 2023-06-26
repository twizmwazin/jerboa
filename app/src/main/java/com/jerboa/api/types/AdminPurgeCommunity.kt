package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AdminPurgeCommunity(
    val id: Int,
    val admin_person_id: PersonId,
    val reason: String?,
    val when_: String,
)
