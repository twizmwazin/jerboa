package com.jerboa.api.compat.v0_17_2.types
data class DeleteCommunity(
    val communityId: CommunityId,
    val deleted: Boolean,
    val auth: String,
)
