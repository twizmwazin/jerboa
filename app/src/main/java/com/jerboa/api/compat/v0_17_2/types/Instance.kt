package com.jerboa.api.compat.v0_17_2.types
data class Instance(
    val id: Int,
    val domain: String,
    val published: String,
    val updated: String?,
    val software: String?,
    val version: String?,
)
