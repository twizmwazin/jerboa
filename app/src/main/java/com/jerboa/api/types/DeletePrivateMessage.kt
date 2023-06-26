package com.jerboa.api.types
 data class DeletePrivateMessage(
    val private_message_id: PrivateMessageId,
    val deleted: Boolean,
    val auth: String,
)
