package com.jerboa.api.compat.v0_17_2.types
data class MarkPrivateMessageAsRead(
    val private_message_id: Int,
    val read: Boolean,
    val auth: String,
)
