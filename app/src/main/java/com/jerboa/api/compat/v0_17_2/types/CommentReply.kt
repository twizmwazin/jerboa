package com.jerboa.api.compat.v0_17_2.types
data class CommentReply (
    val id: CommentReplyId,
    val recipient_id: PersonId,
    val comment_id: CommentId,
    val read: Boolean,
    val published: String,
 )