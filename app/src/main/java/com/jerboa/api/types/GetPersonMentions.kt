package com.jerboa.api.types
 data class GetPersonMentions(
    val sort: CommentSortType?,
    val page: Int? = null,
    val limit: Int? = null,
    val unread_only: Boolean?,
    val auth: String,
)
