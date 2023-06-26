package com.jerboa.api.compat.v0_17_2.types
data class RegistrationApplication(
    val id: Int,
    val local_user_id: LocalUserId,
    val answer: String,
    val admin_id: PersonId?,
    val deny_reason: String?,
    val published: String,
)
