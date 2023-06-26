package com.jerboa.api.types
 data class ModlogListParams(
    val community_id: CommunityId?,
    val mod_person_id: PersonId?,
    val other_person_id: PersonId?,
    val page: Int?,
    val limit: Int?,
    val hide_modlog_names: Boolean,
)
