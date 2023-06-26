package com.jerboa.api.compat.v0_17_2.types
data class AdminPurgePost(
    val id: Int,
    val admin_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String? = null,
    val when_: String,
)
