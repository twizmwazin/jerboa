package com.jerboa.api.types
 data class ResolvePrivateMessageReport(
    val report_id: PrivateMessageReportId,
    val resolved: Boolean,
    val auth: String,
)
