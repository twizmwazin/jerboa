package com.jerboa.api.compat.v0_17_2.types
data class RegistrationApplicationView(
    val registration_application: RegistrationApplication,
    val creator_local_user: LocalUser,
    val creator: Person,
    val admin: Person?,
)
