package com.jerboa.api.compat.v0_17_2.types
data class GetPersonMentions(
    val sort: CommentSortType?,
    val page: Int?,
    val limit: Int?,
    val unread_only: Boolean?,
    val auth: String,
)
