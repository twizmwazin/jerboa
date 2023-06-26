package com.jerboa.api.compat.v0_17_2.types
data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val moderates: List<CommunityModeratorView>,
)
