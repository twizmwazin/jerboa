package com.jerboa.api.types
 data class GetSiteResponse(
     val site_view: SiteView,
     val admins: List<PersonView>,
     val online: Int,
     val version: String,
     val my_user: MyUserInfo?,
     val all_languages: List<Language>,
     val discussion_languages: List<LanguageId>,
     val taglines: List<Tagline>,
     val custom_emojis: List<CustomEmojiView>,
)
