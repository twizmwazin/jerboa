package com.jerboa.api.compat.v0_17_2.types
data class ModRemoveComment (
    val id: Int,
    val mod_person_id: PersonId,
    val comment_id: CommentId,
    val reason: String?,
    val removed: Boolean,
    val when_: String,
 )
