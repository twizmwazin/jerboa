package com.jerboa.api.compat.v0_17_2.types
data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String?,
    val auth: String,
)
