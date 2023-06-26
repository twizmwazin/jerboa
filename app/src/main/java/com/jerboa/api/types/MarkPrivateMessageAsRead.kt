package com.jerboa.api.types
 data class MarkPrivateMessageAsRead(
    val private_message_id: Int,
    val read: Boolean,
    val auth: String,
)
