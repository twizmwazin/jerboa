package com.jerboa.api.types
 data class RemoveComment(
    val comment_id: Int,
    val removed: Boolean,
    val reason: String? = null,
    val auth: String,
)
