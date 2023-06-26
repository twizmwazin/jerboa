package com.jerboa.api.types
 data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType,
    val auth: String,
)
