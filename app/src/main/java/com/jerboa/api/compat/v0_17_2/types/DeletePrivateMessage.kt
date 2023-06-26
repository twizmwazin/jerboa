package com.jerboa.api.compat.v0_17_2.types
data class DeletePrivateMessage(
    val private_message_id: PrivateMessageId,
    val deleted: Boolean,
    val auth: String,
)
