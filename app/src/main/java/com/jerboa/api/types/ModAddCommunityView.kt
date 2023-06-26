package com.jerboa.api.types
 data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person?,
    val community: Community,
    val modded_person: Person,
)
