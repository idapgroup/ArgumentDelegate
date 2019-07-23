package com.idapgroup.argumentdelegate

import android.app.Activity
import androidx.fragment.app.Fragment

/**
 * Extension function for android.app.Activity that simplify
 * android.os.Bundle unpacking.
 * @return ReadOnlyProperty
 * Usage example:
 * val argument: Int by argumentsDelegate()
 */
inline fun <reified T> Activity.argumentDelegate(): LazyProvider<Activity, T> {
    return argumentDelegate { it.intent?.extras }
}

/**
 * Extension function for androidx.fragment.app.Fragment that simplify
 * {@link android.os.Bundle} unpacking.
 * @return ReadOnlyProperty
 * Usage example:
 * val argument: Int by argumentsDelegate()
 */
inline fun <reified T> Fragment.argumentDelegate(): LazyProvider<Fragment, T> {
    return argumentDelegate { it.arguments }
}

