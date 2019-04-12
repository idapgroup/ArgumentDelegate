package com.idapgroup.argumentdelegate

import android.app.Activity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ArgumentActivityTest {

    @Test
    fun testThrows() {
        val activity = ArgsActivity()
        assertThrows<RuntimeException> { activity.arg }
    }

}

class ArgsActivity : Activity() {

    val arg by argumentDelegate<Int>()

}