package com.jerboa.api.compat.v0_17_2.types
data class EditComment(
    val comment_id: Int,
    val content: String?,
    val language_id: Int?,
    val form_id: String?,
    val auth: String,
)
