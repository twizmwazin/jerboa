package com.jerboa.api.compat.v0_17_2.types
data class ResolvePrivateMessageReport(
    val report_id: PrivateMessageReportId,
    val resolved: Boolean,
    val auth: String,
)
