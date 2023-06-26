package com.jerboa.api.compat.v0_17_2.types
data class AdminPurgeComment(
    val id: Int,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String?,
    val when_: String,
)
