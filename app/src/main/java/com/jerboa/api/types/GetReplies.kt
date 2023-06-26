package com.jerboa.api.types
 data class GetReplies(
    val sort: CommentSortType? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val unread_only: Boolean? = null,
    val auth: String,
)
