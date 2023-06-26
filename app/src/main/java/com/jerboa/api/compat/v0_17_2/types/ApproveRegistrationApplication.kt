package com.jerboa.api.compat.v0_17_2.types
data class ApproveRegistrationApplication(
    val id: Int,
    val approve: Boolean,
    val deny_reason: String?,
    val auth: String,
)
