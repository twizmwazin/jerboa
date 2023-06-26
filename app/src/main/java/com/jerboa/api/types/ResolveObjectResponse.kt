package com.jerboa.api.types
 data class ResolveObjectResponse(
    val comment: CommentView?,
    val post: PostView?,
    val community: CommunityView?,
    val person: PersonView?,
)
