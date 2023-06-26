package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AddModToCommunityResponse(
    val moderators: List<CommunityModeratorView>,
)
