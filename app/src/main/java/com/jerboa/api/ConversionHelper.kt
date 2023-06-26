package com.jerboa.api

import retrofit2.Response
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

fun <T : Any> Any.convertTo(kClass: KClass<T>): T {
    val constructor = kClass.primaryConstructor
        ?: throw IllegalArgumentException("Class doesn't have a primary constructor")

    val propertiesByName = this::class.memberProperties.associateBy { it.name }

    return constructor.callBy(args = constructor.parameters.associateWith { parameter ->
        when (val property = propertiesByName[parameter.name]) {
            null -> if (parameter.type.isMarkedNullable) null else throw IllegalArgumentException("Missing property ${parameter.name}")
            else -> {
                val value = property.call(this)
                value?.takeIf { it::class == parameter.type.classifier }
                    ?: value?.convertTo(parameter.type.classifier as KClass<*>)
                    ?: value
            }
        }
    })
}

inline fun <reified T : Any> Any.convert(): T {
    return convertTo(T::class)
}

// Converts a Response object by keeping everything the same but changing the generic type
inline fun <B, reified A> convertResponse(response: Response<B>): Response<A> {
    return if (response.isSuccessful) {
        Response.success(response.body()!!.convertTo(A::class as KClass<*>) as A)
    } else {
        Response.error(response.code(), response.errorBody()!!)
    }
}
