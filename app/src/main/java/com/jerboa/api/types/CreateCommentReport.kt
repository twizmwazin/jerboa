package com.jerboa.api.types
 data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
    val auth: String,
)
