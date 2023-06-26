package com.jerboa.api.compat.v0_17_2.types
data class ChangePassword(
    val new_password: String,
    val new_password_verify: String,
    val old_password: String,
    val auth: String,
)
