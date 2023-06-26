package com.jerboa.api.types
 data class CreatePostLike(
    val postId: PostId,
    val score: Int,
    val auth: String,
)
