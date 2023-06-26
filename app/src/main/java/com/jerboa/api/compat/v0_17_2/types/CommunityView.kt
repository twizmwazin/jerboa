package com.jerboa.api.compat.v0_17_2.types
data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType,
    val blocked: Boolean,
    val counts: CommunityAggregates,
)
