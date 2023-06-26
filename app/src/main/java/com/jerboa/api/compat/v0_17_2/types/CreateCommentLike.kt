package com.jerboa.api.compat.v0_17_2.types
data class CreateCommentLike(
    val comment_id: CommentId,
    val score: Int,
    val auth: String,
)
