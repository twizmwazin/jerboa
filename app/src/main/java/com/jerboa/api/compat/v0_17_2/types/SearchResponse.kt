package com.jerboa.api.compat.v0_17_2.types
data class SearchResponse(
    val type_: SearchType,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val users: List<PersonView>,
)
