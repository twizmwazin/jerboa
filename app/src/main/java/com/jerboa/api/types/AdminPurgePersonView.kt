package com.jerboa.api.types

import kotlinx.serialization.Serializable


data class AdminPurgePersonView(
    val admin_purge_person: AdminPurgePerson,
    val admin: Person?,
)
