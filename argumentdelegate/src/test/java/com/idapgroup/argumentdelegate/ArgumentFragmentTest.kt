package com.idapgroup.argumentdelegate

import androidx.fragment.app.Fragment
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ArgumentFragmentTest {

    @Test
    fun testThrows() {
        val fragment = ArgsFragment()
        assertThrows<RuntimeException> { fragment.arg }
    }

}

class ArgsFragment : Fragment() {

    val arg by argumentDelegate<Int>()

}

