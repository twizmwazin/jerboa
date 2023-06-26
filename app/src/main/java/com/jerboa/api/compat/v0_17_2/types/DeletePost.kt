package com.jerboa.api.compat.v0_17_2.types
data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
    val auth: String,
)
