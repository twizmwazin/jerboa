package com.jerboa.api.compat.v0_17_2.types
data class ModAddCommunity (
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val community_id: CommunityId,
    val removed: Boolean,
    val when_: String,
 )
