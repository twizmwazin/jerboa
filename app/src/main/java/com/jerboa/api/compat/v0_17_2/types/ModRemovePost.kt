package com.jerboa.api.compat.v0_17_2.types
data class ModRemovePost(
    val id: Int,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
)
