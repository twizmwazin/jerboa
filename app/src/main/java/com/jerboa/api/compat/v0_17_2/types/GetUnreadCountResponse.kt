package com.jerboa.api.compat.v0_17_2.types
data class GetUnreadCountResponse(
    val replies: Int,
    val mentions: Int,
    val private_messages: Int,
)
