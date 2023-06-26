package com.jerboa.api.compat.v0_17_2.types
data class PasswordChangeAfterReset(
    val token: String,
    val password: String,
    val password_verify: String,
)
