package com.jerboa.api.compat.v0_17_2.types
data class GetReportCountResponse(
    val community_id: CommunityId?,
    val comment_reports: Int,
    val post_reports: Int,
    val private_message_reports: Int?,
)
