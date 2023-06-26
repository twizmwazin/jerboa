package com.jerboa.api.types
 data class Tagline(
    val id: Int,
    val local_site_id: LocalSiteId,
    val content: String,
    val published: String,
    val updated: String?,
)
