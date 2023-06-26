package com.jerboa.api.types
 data class SearchResponse(
    val type_: SearchType,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val users: List<PersonView>,
)
