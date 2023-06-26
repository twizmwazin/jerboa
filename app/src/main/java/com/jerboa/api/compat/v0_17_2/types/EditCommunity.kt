package com.jerboa.api.compat.v0_17_2.types
data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId> = emptyList(),
    val auth: String,
)
