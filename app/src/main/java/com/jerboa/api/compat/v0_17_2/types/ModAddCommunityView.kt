package com.jerboa.api.compat.v0_17_2.types
data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person?,
    val community: Community,
    val modded_person: Person,
)
