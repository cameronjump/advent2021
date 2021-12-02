package com.cameronjump.advent

import android.widget.TextView

class SolverDay01 {

    private fun partOne() {
        val input = ""//getString(R.string.day_01_input_a)

        var count = 0
        var previous = Int.MAX_VALUE
        input.split(" ").forEach {
            val current = Integer.valueOf(it.trim())

            if (previous < current) {
                count += 1
            }

            previous = current
        }

//        findViewById<TextView>(R.id.firstAnswer).apply {
//            text = count.toString()
//        }
    }

    private fun partTwo() {
        val input = "" //getString(R.string.day_01_input_a)

        val digits = input.split(" ").map {
            Integer.valueOf(it.trim())
        }

        var windowStart = 0
        var windowEnd = 2

        val windowSums = mutableListOf<Int>()

        while (windowEnd < digits.size) {
            val windowSum = digits.subList(windowStart, windowEnd + 1).sum()
            windowSums.add(windowSum)

            windowStart += 1
            windowEnd += 1
        }

        var count = 0
        var previous = Int.MAX_VALUE
        windowSums.forEach {
            if (previous < it) {
                count += 1
            }

            previous = it
        }

//        findViewById<TextView>(R.id.secondAnswer).apply {
//            text = count.toString()
//        }
    }

}