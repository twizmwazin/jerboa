package com.jerboa.api.types
 data class ModRemovePostView(
    val mod_remove_post: ModRemovePost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
