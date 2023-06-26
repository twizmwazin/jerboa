package com.jerboa.api.compat.v0_17_2.types
data class MarkPersonMentionAsRead(
    val person_mention_id: PersonMentionId,
    val read: Boolean,
    val auth: String,
)
