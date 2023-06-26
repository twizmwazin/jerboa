package com.jerboa.api.types
 data class ListPrivateMessageReports(
    val page: Int?,
    val limit: Int?,
    val unresolved_only: Boolean?,
    val auth: String,
)
