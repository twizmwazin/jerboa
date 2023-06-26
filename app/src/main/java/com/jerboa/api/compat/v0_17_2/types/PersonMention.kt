package com.jerboa.api.compat.v0_17_2.types
data class PersonMention(
    val id: PersonMentionId,
    val recipientId: PersonId,
    val commentId: CommentId,
    val read: Boolean,
    val published: String,
)