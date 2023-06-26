package com.jerboa.api.compat.v0_17_2.types
data class ModFeaturePostView(
    val mod_feature_post: ModFeaturePost,
    val moderator: Person?,
    val post: Post,
    val community: Community,
)
