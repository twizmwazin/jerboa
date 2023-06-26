package com.jerboa.api.types
 data class EditSite(
    val name: String?,
    val sidebar: String?,
    val description: String?,
    val icon: String?,
    val banner: String?,
    val enable_downvotes: Boolean?,
    val enable_nsfw: Boolean?,
    val community_creation_admin_only: Boolean?,
    val require_email_verification: Boolean?,
    val application_question: String?,
    val private_instance: Boolean?,
    val default_theme: String?,
    val default_post_listing_type: ListingType?,
    val legal_information: String?,
    val application_email_admins: Boolean?,
    val hide_modlog_mod_names: Boolean?,
    val discussion_languages: List<LanguageId>?,
    val slur_filter_regex: String?,
    val actor_name_max_length: Int?,
    val rate_limit_message: Int?,
    val rate_limit_message_per_second: Int?,
    val rate_limit_post: Int?,
    val rate_limit_post_per_second: Int?,
    val rate_limit_register: Int?,
    val rate_limit_register_per_second: Int?,
    val rate_limit_image: Int?,
    val rate_limit_image_per_second: Int?,
    val rate_limit_comment: Int?,
    val rate_limit_comment_per_second: Int?,
    val rate_limit_search: Int?,
    val rate_limit_search_per_second: Int?,
    val federation_enabled: Boolean?,
    val federation_debug: Boolean?,
    val federation_worker_count: Int?,
    val captcha_enabled: Boolean?,
    val captcha_difficulty: String?,
    val allowed_instances: List<String>?,
    val blocked_instances: List<String>?,
    val taglines: List<String>?,
    val registration_mode: RegistrationMode?,
    val reports_email_admins: Boolean?,
    val auth: String,
)