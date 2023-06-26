package com.jerboa.api.types
 data class ListRegistrationApplications(
    val unread_only: Boolean?,
    val page: Int?,
    val limit: Int?,
    val auth: String,
)
