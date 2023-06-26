package com.jerboa.api.types
 data class EditComment(
    val comment_id: Int,
    val content: String? = null,
    val language_id: Int? = null,
    val form_id: String? = null,
    val auth: String,
)
