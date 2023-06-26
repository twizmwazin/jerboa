package com.jerboa.api.compat.v0_17_2.types
data class MarkCommentReplyAsRead(
    val comment_reply_id: CommentReplyId,
    val read: Boolean,
    val auth: String,
)
