package com.jerboa.api.compat.v0_17_2.types
data class PrivateMessageView(
    val private_message: PrivateMessage,
    val creator: Person,
    val recipient: Person,
)
