package com.jerboa.api.types
 data class PersonMention(
    val id: PersonMentionId,
    val recipientId: PersonId,
    val commentId: CommentId,
    val read: Boolean,
    val published: String,
)
