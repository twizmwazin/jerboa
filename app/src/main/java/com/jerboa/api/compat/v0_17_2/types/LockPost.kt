package com.jerboa.api.compat.v0_17_2.types
data class LockPost(
    val postId: Int,
    val locked: Boolean,
    val auth: String,
)
