package com.jerboa.api.compat.v0_17_2.types
data class AdminPurgeCommentView(
    val admin_purge_comment: AdminPurgeComment,
    val admin: Person?,
    val post: Post,
)
