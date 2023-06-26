package com.jerboa.api.compat.v0_17_2.types
data class AddModToCommunity(
    val community_id: Int,
    val person_id: Int,
    val added: Boolean,
    val auth: String,
)

