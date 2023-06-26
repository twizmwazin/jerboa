package com.jerboa.api.compat.v0_17_2.types
data class GetComments (
    var type_: ListingType?,
    var sort: CommentSortType?,
    var max_depth: Int?,
    var page: Int?,
    var limit: Int?,
    var community_id: CommunityId?,
    var community_name: String?,
    var post_id: PostId?,
    var parent_id: CommentId?,
    var saved_only: Boolean?,
    var auth: String?,
 )
