package com.jerboa.api.types
 data class CreateComment(
    val content: String,
    val post_id: Int,
    val parent_id: Int? = null,
    val language_id: Int? = null,
    val form_id: String? = null,
    val auth: String,
)
