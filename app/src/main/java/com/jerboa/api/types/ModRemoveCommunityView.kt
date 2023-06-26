package com.jerboa.api.types
 data class ModRemoveCommunityView(
    val mod_remove_community: ModRemoveCommunity,
    val moderator: Person?,
    val community: Community,
)
