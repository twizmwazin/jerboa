package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AdminPurgeComment(
    val id: Int,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String?,
    val when_: String,
)
