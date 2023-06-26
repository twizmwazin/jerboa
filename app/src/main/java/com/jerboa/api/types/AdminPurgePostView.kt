package com.jerboa.api.types
 data class AdminPurgePostView(
    val admin_purge_post: AdminPurgePost,
    val admin: Person?,
    val community: Community,
)
