package com.jerboa.api.types
 data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Int,
    val auth: String,
)
