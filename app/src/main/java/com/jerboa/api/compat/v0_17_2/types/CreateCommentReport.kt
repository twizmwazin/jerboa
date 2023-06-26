package com.jerboa.api.compat.v0_17_2.types
data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
    val auth: String,
)
