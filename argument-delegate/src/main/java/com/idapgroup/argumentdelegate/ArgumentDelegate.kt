package com.idapgroup.argumentdelegate

import android.os.Bundle
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Function that simplify android.os.Bundle unpacking.
 * @param argumentWrapper block function, that expect android.os.Bundle from object,
 * Usage example:
 * private val wrapper = { f: Fragment -> a.arguments }
 * @return ReadOnlyProperty, Usage example:
 * val argument: Int by argumentsDelegate(wrapper)
 */
inline fun <F, reified T> argumentDelegate(
    crossinline argumentWrapper: (F) -> Bundle
): ReadOnlyProperty<F, T> =
    object : ReadOnlyProperty<F, T> {

        private var initialized = false
        private var value: Any? = null

        override operator fun getValue(thisRef: F, property: KProperty<*>): T {
            if (!initialized) {
                value =
                    getArgument(argumentWrapper(thisRef), property, T::class.java)
                initialized = true
            }
            return value as T
        }
    }

inline fun <reified T> getArgument(
    args: Bundle,
    property: KProperty<*>,
    clazz: Class<T>
): T {
    val value = args.get(property.name)
    return when {
        value == null -> {
            if (isNullable<T>()) {
                null as T
            } else {
                throw KotlinNullPointerException("${T::class.java} can't be cast to nullable type")
            }
        }
        clazz.isAssignableFrom(value::class.java) -> value as T
        else -> throw RuntimeException("Property ${property.name} has a wrong type or can't be mapped")
    }
}

