package com.jerboa.api.compat.v0_17_2.types
data class FederatedInstances(
    val linked: List<Instance>,
    val allowed: List<Instance>,
    val blocked: List<Instance>,
)
