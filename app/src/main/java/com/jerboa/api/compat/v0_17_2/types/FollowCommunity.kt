package com.jerboa.api.compat.v0_17_2.types
data class FollowCommunity(
    val community_id: CommunityId,
    val follow: Boolean,
    val auth: String,
)
