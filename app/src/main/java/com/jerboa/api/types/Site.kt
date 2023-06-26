package com.jerboa.api.types
 data class Site (
    var id: SiteId,
    var name: String,
    var sidebar: String?,
    var published: String,
    var updated: String?,
    var icon: String?,
    var banner: String?,
    var description: String?,
    var actor_id: String,
    var last_refreshed_at: String,
    var inbox_url: String,
    var private_key: String?,
    var public_key: String,
    var instance_id: InstanceId,
 )
