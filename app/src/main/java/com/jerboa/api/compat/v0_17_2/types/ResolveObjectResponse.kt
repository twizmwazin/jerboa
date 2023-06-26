package com.jerboa.api.compat.v0_17_2.types
data class ResolveObjectResponse(
    val comment: CommentView?,
    val post: PostView?,
    val community: CommunityView?,
    val person: PersonView?,
)
