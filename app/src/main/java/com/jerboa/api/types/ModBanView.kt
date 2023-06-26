package com.jerboa.api.types
 data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person?,
    val banned_person: Person,
)
