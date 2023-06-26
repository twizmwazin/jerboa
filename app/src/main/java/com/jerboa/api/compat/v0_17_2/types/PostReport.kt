package com.jerboa.api.compat.v0_17_2.types
data class PostReport(
    val id: PostReportId,
    val creator_id: PersonId,
    val post_id: PostId,
    val original_post_name: String,
    val original_post_url: String?,
    val original_post_body: String?,
    val reason: String,
    val resolved: Boolean,
    val resolver_id: PersonId?,
    val published: String,
    val updated: String?,
)
