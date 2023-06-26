package com.jerboa.api.types
 data class PurgePost(
    val post_id: Int,
    val reason: String? = null,
    val auth: String,
)
