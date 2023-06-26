package com.jerboa.api.types
 data class EditPost (
    val post_id: PostId,
    val name: String?,
    val url: String?,
    val body: String?,
    val nsfw: Boolean?,
    val language_id: LanguageId?,
    val auth: String,
 )
