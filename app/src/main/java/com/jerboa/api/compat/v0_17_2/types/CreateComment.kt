package com.jerboa.api.compat.v0_17_2.types
data class CreateComment(
    val content: String,
    val post_id: Int,
    val parent_id: Int?,
    val language_id: Int?,
    val form_id: String?,
    val auth: String,
)
