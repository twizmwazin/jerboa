package com.jerboa.api.types
 data class ModHideCommunityView(
    val mod_hide_community: ModHideCommunity,
    val admin: Person?,
    val community: Community,
)
