package com.jerboa.api.types
 data class CreateCommunity(
    val name: String,
    val title: String,
    val description: String?,
    val icon: String?,
    val banner: String?,
    val nsfw: Boolean?,
    val posting_restricted_to_mods: Boolean?,
    val discussion_languages: List<Int>?,
    val auth: String,
)
