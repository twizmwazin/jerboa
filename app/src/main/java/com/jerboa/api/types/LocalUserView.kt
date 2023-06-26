package com.jerboa.api.types
 data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val counts: PersonAggregates,
)
