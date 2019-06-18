package com.idapgroup.argumentdelegate

import android.os.Bundle
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ArgumentDelegateTest {

    @Test
    fun testArguments() {
        val value = "random"
        val bundle = Bundle().apply {
            putString("argument", value)
            putString("nullArgument", null)
            putString("wrongNull", null)
            putString("nullableWithValueArgument", value)
            putInt("intArg", 12)
        }
        val argumentHolder = ArgumentHolder(bundle)
        assertEquals(argumentHolder.argument, value)
        assertEquals(argumentHolder.nullArgument, null)
        assertEquals(argumentHolder.nullableWithValueArgument, value)
        assertThrows<RuntimeException> { argumentHolder.intArg }
        assertThrows<TypeCastException> { argumentHolder.wrongNull }
        assertThrows<RuntimeException> { argumentHolder.wrongArgument }
    }

}

class ArgumentHolder(
    private val bundle: Bundle
) {

    private val wrapper = { a: ArgumentHolder -> a.bundle }
    val argument: String by argumentDelegate(wrapper)
    val nullArgument: String? by argumentDelegate(wrapper)
    val wrongNull: String by argumentDelegate(wrapper)
    val nullableWithValueArgument: String? by argumentDelegate(wrapper)
    val wrongArgument: String by argumentDelegate(wrapper)
    val intArg: String by argumentDelegate(wrapper)

}

inline fun <reified T: Exception> assertThrows(block: () -> Unit) {
    try {
        block()
        Assert.fail("Block doesn't throw anything.")
    } catch (e: Exception) {
        if(e !is T) {
            Assert.fail("Thrown exception doesn't match with expected.")
        }
    }
}


