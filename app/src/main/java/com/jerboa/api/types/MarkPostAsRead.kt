package com.jerboa.api.types
 data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
    val auth: String,
)
