package com.idapgroup.argumentdelegate

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TypeExtTest {

    @Test
    fun isClassNullable() {
        assertTrue(isNullable<String?>())
        assertTrue(isNullable<Int?>())
        assertTrue(isNullable<ForTest?>())
    }

    @Test
    fun isClassNullSafe() {
        assertFalse(isNullable<String>())
        assertFalse(isNullable<Int>())
        assertFalse(isNullable<ForTest>())
    }

}

class ForTest