package com.idapgroup.argumentdelegate

import android.app.Activity
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty

/**
 * Extension function for android.app.Activity that simplify
 * android.os.Bundle unpacking.
 * @return ReadOnlyProperty
 * Usage example:
 * val argument: Int by argumentsDelegate()
 */
inline fun <reified T> Activity.argumentDelegate(): ReadOnlyProperty<Activity, T> {
    return argumentDelegate {
        it.intent?.extras ?: throw java.lang.RuntimeException("No arguments passed")
    }
}

/**
 * Extension function for androidx.fragment.app.Fragment that simplify
 * {@link android.os.Bundle} unpacking.
 * @return ReadOnlyProperty
 * Usage example:
 * val argument: Int by argumentsDelegate()
 */
inline fun <reified T> Fragment.argumentDelegate(): ReadOnlyProperty<Fragment, T> {
    return argumentDelegate {
        it.arguments ?: throw RuntimeException("No arguments passed")
    }
}

