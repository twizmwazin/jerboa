package com.jerboa.api.types
 data class DeleteCommunity(
    val communityId: CommunityId,
    val deleted: Boolean,
    val auth: String,
)
