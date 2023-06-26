package com.jerboa.api.types
 data class Community(
    val id: CommunityId,
    val name: String,
    val title: String,
    val description: String?,
    val removed: Boolean,
    val published: String,
    val updated: String?,
    val deleted: Boolean,
    val nsfw: Boolean,
    val actor_id: String,
    val local: Boolean,
    val icon: String?,
    val banner: String?,
    val hidden: Boolean,
    val posting_restricted_to_mods: Boolean,
    val instance_id: InstanceId,
)
