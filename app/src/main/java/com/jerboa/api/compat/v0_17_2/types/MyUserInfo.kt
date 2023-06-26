package com.jerboa.api.compat.v0_17_2.types
data class MyUserInfo(
    val local_user_view: LocalUserView,
    val follows: List<CommunityFollowerView>,
    val moderates: List<CommunityModeratorView>,
    val community_blocks: List<CommunityBlockView>,
    val person_blocks: List<PersonBlockView>,
    val discussion_languages: List<Int>,
)
