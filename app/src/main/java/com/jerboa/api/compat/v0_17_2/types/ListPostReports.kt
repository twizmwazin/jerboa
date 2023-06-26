package com.jerboa.api.compat.v0_17_2.types
data class ListPostReports(
    val page: Int?,
    val limit: Int?,
    val unresolved_only: Boolean?,
    val community_id: CommunityId?,
    val auth: String,
)
