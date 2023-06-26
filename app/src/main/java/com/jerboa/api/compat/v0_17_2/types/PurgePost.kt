package com.jerboa.api.compat.v0_17_2.types
data class PurgePost(
    val post_id: Int,
    val reason: String? = null,
    val auth: String,
)
