package com.jerboa.api.types
 data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
    val auth: String,
)
