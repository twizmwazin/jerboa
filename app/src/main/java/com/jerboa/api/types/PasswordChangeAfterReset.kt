package com.jerboa.api.types
 data class PasswordChangeAfterReset(
    val token: String,
    val password: String,
    val password_verify: String,
)
