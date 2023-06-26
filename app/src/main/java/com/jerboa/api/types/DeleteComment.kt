package com.jerboa.api.types
 data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
    val auth: String,
)
