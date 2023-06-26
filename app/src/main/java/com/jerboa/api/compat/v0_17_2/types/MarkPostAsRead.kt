package com.jerboa.api.compat.v0_17_2.types
data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
    val auth: String,
)
