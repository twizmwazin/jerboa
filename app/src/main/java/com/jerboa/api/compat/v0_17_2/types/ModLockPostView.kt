package com.jerboa.api.compat.v0_17_2.types
data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
