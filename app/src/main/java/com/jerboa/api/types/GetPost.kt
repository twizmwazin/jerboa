package com.jerboa.api.types

 data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
    val auth: String?,
)
