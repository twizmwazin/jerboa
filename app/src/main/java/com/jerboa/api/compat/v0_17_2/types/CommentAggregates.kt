package com.jerboa.api.compat.v0_17_2.types
data class CommentAggregates(
    val id: Int,
    val comment_id: CommentId,
    val score: Int,
    val upvotes: Int,
    val downvotes: Int,
    val published: String,
    val child_count: Int,
)