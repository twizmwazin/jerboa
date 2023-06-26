package com.jerboa.api.compat.v0_17_2.types
data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType,
    val auth: String,
)
