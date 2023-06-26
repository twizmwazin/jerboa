package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AddAdminResponse(
    val admins: List<PersonView>,
)
