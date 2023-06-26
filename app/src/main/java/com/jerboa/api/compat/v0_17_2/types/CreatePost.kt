package com.jerboa.api.compat.v0_17_2.types
data class CreatePost(
    val name: String,
    val community_id: Int,
    val url: String?,
    val body: String?,
    val honeypot: String?,
    val nsfw: Boolean?,
    val language_id: Int?,
    val auth: String,
)
