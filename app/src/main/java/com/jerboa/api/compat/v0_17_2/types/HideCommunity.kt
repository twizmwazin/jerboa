package com.jerboa.api.compat.v0_17_2.types
data class HideCommunity(
    val communityId: Int,
    val hidden: Boolean,
    val reason: String? = null,
    val auth: String,
)
