package com.jerboa.api.types
 data class GetModlog(
    val mod_person_id: PersonId?,
    val community_id: CommunityId?,
    val page: Int?,
    val limit: Int?,
    val type_: ModlogActionType?,
    val other_person_id: PersonId?,
    val auth: String?,
)
