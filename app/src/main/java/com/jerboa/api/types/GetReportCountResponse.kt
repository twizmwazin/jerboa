package com.jerboa.api.types
 data class GetReportCountResponse(
    val community_id: CommunityId?,
    val comment_reports: Int,
    val post_reports: Int,
    val private_message_reports: Int?,
)
