package com.jerboa.api.compat.v0_17_2.types
data class DeleteComment(
    val comment_id: CommentId,
    val deleted: Boolean,
    val auth: String,
)
