package com.jerboa.api.compat.v0_17_2.types
data class CreatePostLike(
    val postId: PostId,
    val score: Int,
    val auth: String,
)
