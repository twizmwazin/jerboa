package com.jerboa.api.types
 data class GetPosts (
    var type_: ListingType?,
    var sort: SortType?,
    var page: Int?,
    var limit: Int?,
    var community_id: CommunityId?,
    var community_name: String?,
    var saved_only: Boolean?,
    var auth: String?,
 )
