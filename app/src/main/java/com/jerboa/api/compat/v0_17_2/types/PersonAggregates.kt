package com.jerboa.api.compat.v0_17_2.types
data class PersonAggregates(
    val id: Int,
    val person_id: PersonId,
    val post_count: Int,
    val post_score: Int,
    val comment_count: Int,
    val comment_score: Int,
)
