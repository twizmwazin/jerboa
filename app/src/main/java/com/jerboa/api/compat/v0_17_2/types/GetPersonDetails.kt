package com.jerboa.api.compat.v0_17_2.types
data class GetPersonDetails(
    val person_id: PersonId?,
    val username: String?,
    val sort: SortType?,
    val page: Int?,
    val limit: Int?,
    val community_id: CommunityId?,
    val saved_only: Boolean?,
    val auth: String?,
)
