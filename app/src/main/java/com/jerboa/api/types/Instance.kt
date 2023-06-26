package com.jerboa.api.types
 data class Instance(
    val id: Int,
    val domain: String,
    val published: String,
    val updated: String?,
    val software: String?,
    val version: String?,
)
