package com.jerboa.api.types
 data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType,
    val blocked: Boolean,
    val counts: CommunityAggregates,
)
