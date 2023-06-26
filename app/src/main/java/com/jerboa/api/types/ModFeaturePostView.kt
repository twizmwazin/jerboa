package com.jerboa.api.types
 data class ModFeaturePostView(
    val mod_feature_post: ModFeaturePost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
