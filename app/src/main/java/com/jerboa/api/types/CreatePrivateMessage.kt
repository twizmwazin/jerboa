package com.jerboa.api.types
 data class CreatePrivateMessage(
    val content: String,
    val recipient_id: Int,
    val auth: String,
)
