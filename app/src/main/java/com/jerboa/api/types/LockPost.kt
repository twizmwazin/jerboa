package com.jerboa.api.types
 data class LockPost(
    val postId: Int,
    val locked: Boolean,
    val auth: String,
)
