package com.jerboa.api.types
 data class ApproveRegistrationApplication(
    val id: Int,
    val approve: Boolean,
    val deny_reason: String?,
    val auth: String,
)
