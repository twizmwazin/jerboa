package com.jerboa.api.types
 data class RemovePost(
    val post_id: Int,
    val removed: Boolean,
    val reason: String?,
    val auth: String,
)
