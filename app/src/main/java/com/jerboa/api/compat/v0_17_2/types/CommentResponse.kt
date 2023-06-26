package com.jerboa.api.compat.v0_17_2.types
data class CommentResponse(
    val comment_view: CommentView,
    val recipient_ids: List<LocalUserId>,
    val form_id: String?,
)
