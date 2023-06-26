package com.jerboa.api.types
 data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
    val auth: String,
)
