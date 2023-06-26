package com.jerboa.api.types
 data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
    val auth: String,
)
