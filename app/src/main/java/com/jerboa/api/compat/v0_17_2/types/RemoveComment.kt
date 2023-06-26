package com.jerboa.api.compat.v0_17_2.types
data class RemoveComment(
    val comment_id: Int,
    val removed: Boolean,
    val reason: String? = null,
    val auth: String,
)
