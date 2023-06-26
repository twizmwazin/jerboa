package com.jerboa.api.compat.v0_17_2.types
data class ResolvePostReport(
    val report_id: PostReportId,
    val resolved: Boolean,
    val auth: String,
)
