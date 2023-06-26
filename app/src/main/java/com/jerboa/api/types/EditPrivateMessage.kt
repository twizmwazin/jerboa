package com.jerboa.api.types
 data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
    val auth: String,
)
