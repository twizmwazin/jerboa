package com.jerboa.api.types
 data class ListCommunities(
    val type_: ListingType?,
    val sort: SortType?,
    val page: Int?,
    val limit: Int?,
    val auth: String?,
)
