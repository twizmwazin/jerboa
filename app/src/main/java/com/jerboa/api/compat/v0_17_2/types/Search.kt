package com.jerboa.api.compat.v0_17_2.types
data class Search(
    val q: String,
    val community_id: CommunityId?,
    val community_name: String?,
    val creator_id: PersonId?,
    val type_: SearchType?,
    val sort: SortType?,
    val listing_type: ListingType?,
    val page: Int?,
    val limit: Int?,
    val auth: String?,
)
