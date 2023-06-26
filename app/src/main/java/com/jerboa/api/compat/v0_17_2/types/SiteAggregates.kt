package com.jerboa.api.compat.v0_17_2.types
data class SiteAggregates(
    val id: Int,
    val site_id: SiteId,
    val users: Int,
    val posts: Int,
    val comments: Int,
    val communities: Int,
    val users_active_day: Int,
    val users_active_week: Int,
    val users_active_month: Int,
    val users_active_half_year: Int,
)
