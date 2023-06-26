package com.jerboa.api.types
 data class LocalSite(
    val id: LocalSiteId,
    val site_id: SiteId,
    val site_setup: Boolean,
    val enable_downvotes: Boolean,
    val enable_nsfw: Boolean,
    val community_creation_admin_only: Boolean,
    val require_email_verification: Boolean,
    val application_question: String?,
    val private_instance: Boolean,
    val default_theme: String,
    val default_post_listing_type: ListingType,
    val legal_information: String?,
    val hide_modlog_mod_names: Boolean,
    val application_email_admins: Boolean,
    val slur_filter_regex: String?,
    val actor_name_max_length: Int,
    val federation_enabled: Boolean,
    val federation_debug: Boolean,
    val federation_worker_count: Int,
    val captcha_enabled: Boolean,
    val captcha_difficulty: String,
    val published: String,
    val updated: String?,
    val registration_mode: RegistrationMode,
    val reports_email_admins: Boolean,
)
