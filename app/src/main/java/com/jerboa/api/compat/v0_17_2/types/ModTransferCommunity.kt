package com.jerboa.api.compat.v0_17_2.types
data class ModTransferCommunity(
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val when_: String,
)
