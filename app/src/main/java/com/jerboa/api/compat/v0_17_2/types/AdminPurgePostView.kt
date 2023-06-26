package com.jerboa.api.compat.v0_17_2.types
data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person?,
    val community: Community,
)
