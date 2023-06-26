package com.jerboa.api.compat.v0_17_2.types
data class GetCommunityResponse(
    val community_view: CommunityView,
    val site: Site?,
    val moderators: List<CommunityModeratorView>,
    val online: Int,
    val discussion_languages: List<LanguageId>,
)
