package com.jerboa.api.compat.v0_17_2.types
data class CommentView(
    val comment: Comment,
    val creator: Person,
    val post: Post,
    val community: Community,
    val counts: CommentAggregates,
    val creator_banned_from_community: Boolean,
    val subscribed: SubscribedType,
    val saved: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int?,
)
