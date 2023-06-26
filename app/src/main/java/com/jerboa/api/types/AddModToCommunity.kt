package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AddModToCommunity(
    val community_id: Int,
    val person_id: Int,
    val added: Boolean,
    val auth: String,
)
