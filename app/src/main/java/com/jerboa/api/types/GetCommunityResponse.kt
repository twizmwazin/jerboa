package com.jerboa.api.types
 data class GetCommunityResponse(
    val community_view: CommunityView,
    val site: Site?,
    val moderators: List<CommunityModeratorView>,
    val online: Int,
    val discussion_languages: List<LanguageId>,
)
