package com.jerboa.api.types
 data class LoginResponse(
    val jwt: String?,
    val registration_created: Boolean,
    val verify_email_sent: Boolean,
)
