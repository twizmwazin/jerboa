package com.jerboa.api.types
 data class ModRemoveCommunity(
    val id: Int,
    val mod_person_id: PersonId,
    val community_id: CommunityId,
    val reason: String?,
    val removed: Boolean,
    val expires: String?,
    val when_: String,
)
