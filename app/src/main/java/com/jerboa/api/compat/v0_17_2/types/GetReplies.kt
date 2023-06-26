package com.jerboa.api.compat.v0_17_2.types
data class GetReplies(
    val sort: CommentSortType? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val unread_only: Boolean? = null,
    val auth: String,
)
