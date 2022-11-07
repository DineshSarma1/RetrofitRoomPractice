package com.example.retrofitroompractice4.data
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {

    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expectedSum = 42
        assertEquals(expectedSum, testSample.sum(40,2))
    }
}