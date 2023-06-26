package com.jerboa.api.compat.v0_17_2.types
data class LoginResponse(
    val jwt: String?,
    val registration_created: Boolean,
    val verify_email_sent: Boolean,
)
