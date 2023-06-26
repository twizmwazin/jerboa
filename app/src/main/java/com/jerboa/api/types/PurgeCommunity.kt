package com.jerboa.api.types
 data class PurgeCommunity(
    val community_id: CommunityId,
    val reason: String?,
    val auth: String,
)
