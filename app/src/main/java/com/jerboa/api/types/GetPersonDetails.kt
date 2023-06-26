package com.jerboa.api.types
 data class GetPersonDetails(
    val person_id: PersonId?,
    val username: String?,
    val sort: SortType?,
    val page: Int?,
    val limit: Int? = null,
    val community_id: CommunityId? = null,
    val saved_only: Boolean?,
    val auth: String?,
)
