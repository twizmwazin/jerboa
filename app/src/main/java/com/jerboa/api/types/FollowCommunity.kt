package com.jerboa.api.types
 data class FollowCommunity(
    val community_id: CommunityId,
    val follow: Boolean,
    val auth: String,
)