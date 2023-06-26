package com.jerboa.api.compat.v0_17_2.types
data class CreatePrivateMessage(
    val content: String,
    val recipient_id: Int,
    val auth: String,
)
