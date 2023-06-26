package com.jerboa.api.compat.v0_17_2.types
data class RemoveCommunity(
    val community_id: CommunityId,
    val removed: Boolean,
    val reason: String? = null,
    val expires: Int? = null,
    val auth: String,
)
