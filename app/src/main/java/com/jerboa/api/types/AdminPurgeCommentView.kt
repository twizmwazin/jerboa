package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AdminPurgeCommentView(
    val admin_purge_comment: AdminPurgeComment,
    val admin: Person?,
    val post: Post,
)
