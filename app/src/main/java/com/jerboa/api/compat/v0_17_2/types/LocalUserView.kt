package com.jerboa.api.compat.v0_17_2.types
data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val counts: PersonAggregates,
)
