package com.jerboa.api.types
 data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
