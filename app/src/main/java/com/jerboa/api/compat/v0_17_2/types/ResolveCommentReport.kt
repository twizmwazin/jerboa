package com.jerboa.api.compat.v0_17_2.types
data class ResolveCommentReport(
    val report_id: CommentReportId,
    val resolved: Boolean,
    val auth: String,
)
