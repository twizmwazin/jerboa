package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AdminPurgeCommunityView(
    val admin_purge_community: AdminPurgeCommunity,
    val admin: Person?,
)
