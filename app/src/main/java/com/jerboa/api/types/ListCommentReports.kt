package com.jerboa.api.types
 data class ListCommentReports(
    val page: Int?,
    val limit: Int?,
    val unresolved_only: Boolean?,
    val community_id: CommunityId?,
    val auth: String,
)
