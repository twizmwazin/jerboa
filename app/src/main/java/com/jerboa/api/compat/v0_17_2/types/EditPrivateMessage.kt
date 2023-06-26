package com.jerboa.api.compat.v0_17_2.types
data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
    val auth: String,
)
