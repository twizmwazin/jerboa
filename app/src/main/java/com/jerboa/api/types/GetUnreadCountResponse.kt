package com.jerboa.api.types
 data class GetUnreadCountResponse(
    val replies: Int,
    val mentions: Int,
    val private_messages: Int,
)
