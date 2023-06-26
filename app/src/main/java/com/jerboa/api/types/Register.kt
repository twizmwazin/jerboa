package com.jerboa.api.types
 data class Register(
    val username: String,
    val password: String,
    val password_verify: String,
    val show_nsfw: Boolean,
    val email: String?,
    val captcha_uuid: String?,
    val captcha_answer: String?,
    val honeypot: String?,
    val answer: String?,
)
