package com.jerboa.api.compat.v0_17_2.types
data class ModRemovePostView(
    val mod_remove_post: ModRemovePost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
