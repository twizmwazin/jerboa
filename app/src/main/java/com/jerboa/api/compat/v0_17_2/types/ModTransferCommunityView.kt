package com.jerboa.api.compat.v0_17_2.types
data class ModTransferCommunityView(
    val mod_transfer_community: ModTransferCommunity,
    val moderator: Person? = null,
    val community: Community,
    val modded_person: Person,
)
