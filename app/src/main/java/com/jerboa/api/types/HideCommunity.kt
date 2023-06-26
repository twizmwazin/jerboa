package com.jerboa.api.types
 data class HideCommunity(
    val communityId: Int,
    val hidden: Boolean,
    val reason: String? = null,
    val auth: String,
)
