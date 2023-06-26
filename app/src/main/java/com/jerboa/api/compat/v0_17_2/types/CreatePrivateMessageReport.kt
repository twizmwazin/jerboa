package com.jerboa.api.compat.v0_17_2.types
data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
    val auth: String,
)
