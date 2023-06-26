package com.jerboa.api.compat.v0_17_2.types
data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person?,
    val banned_person: Person,
)
