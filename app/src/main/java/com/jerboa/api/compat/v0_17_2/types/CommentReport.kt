package com.jerboa.api.compat.v0_17_2.types
data class CommentReport(
    val id: CommentReportId,
    val creator_id: PersonId,
    val comment_id: CommentId,
    val original_comment_text: String,
    val reason: String,
    val resolved: Boolean,
    val resolver_id: PersonId?,
    val published: String,
    val updated: String?,
)
