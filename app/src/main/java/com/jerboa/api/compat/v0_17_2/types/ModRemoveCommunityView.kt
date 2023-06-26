package com.jerboa.api.compat.v0_17_2.types
data class ModRemoveCommunityView(
    val mod_remove_community: ModRemoveCommunity,
    val moderator: Person?,
    val community: Community,
)
