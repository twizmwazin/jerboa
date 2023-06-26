package com.jerboa.api.compat.v0_17_2.types
data class ModBanFromCommunityView(
    val mod_ban_from_community: ModBanFromCommunity,
    val moderator: Person?,
    val community: Community,
    val banned_person: Person,
)
