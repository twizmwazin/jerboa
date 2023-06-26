package com.jerboa.api.compat.v0_17_2.types
data class ListCommunities(
    val type_: ListingType?,
    val sort: SortType?,
    val page: Int?,
    val limit: Int?,
    val auth: String?,
)
