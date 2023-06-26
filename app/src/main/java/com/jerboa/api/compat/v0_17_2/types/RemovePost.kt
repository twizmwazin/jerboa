package com.jerboa.api.compat.v0_17_2.types
data class RemovePost(
    val post_id: Int,
    val removed: Boolean,
    val reason: String?,
    val auth: String,
)
