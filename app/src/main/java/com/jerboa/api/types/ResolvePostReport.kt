package com.jerboa.api.types
 data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
    val auth: String,
)
