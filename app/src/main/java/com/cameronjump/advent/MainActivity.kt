package com.cameronjump.advent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        partOne()
        partTwo()
    }

    private fun partOne() {
        val input = getString(R.string.day_03_input_a)

        val inputs = input.split(" ").map { it.trim() }

        var gammaRate = ""
        var epsilonRate = ""

        for (i in inputs[0].indices) {
            var zeroCount = 0
            var oneCount = 0

            inputs.forEach {
                val char = it[i]

                if (char == '0') {
                    zeroCount += 1
                } else {
                    oneCount += 1
                }
            }

            if (zeroCount == oneCount) {
                throw Exception()
            }

            gammaRate += if (zeroCount > oneCount) {
                0
            } else 1

            epsilonRate += if (zeroCount > oneCount) {
                1
            } else 0
        }

        val answer = Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)

        findViewById<TextView>(R.id.firstAnswer).apply {
            text = answer.toString()
        }
    }

    private fun partTwo() {
        val input = getString(R.string.day_03_input_a)

        val inputs = input.split(" ").map { it.trim() }

        val oxygen = goDownOxygen(inputs, 0)
        val co2 = goDownCO2(inputs, 0)

        val answer = Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)

        findViewById<TextView>(R.id.secondAnswer).apply {
            text = answer.toString()
        }
    }

    private fun goDownOxygen(inputs: List<String>, index: Int): String {
        if (inputs.size == 1) {
            return inputs[0]
        }

        var zeroCount = 0
        var oneCount = 0

        inputs.forEach {
            val char = it[index]

            if (char == '0') {
                zeroCount += 1
            } else {
                oneCount += 1
            }
        }

        return goDownOxygen(
            inputs.toList().filter {
                if (oneCount >= zeroCount) {
                    it[index] == '1'
                } else {
                    it[index] == '0'
                }
            },
            index + 1
        )
    }

    private fun goDownCO2(inputs: List<String>, index: Int): String {
        if (inputs.size == 1) {
            return inputs[0]
        }

        var zeroCount = 0
        var oneCount = 0

        inputs.forEach {
            val char = it[index]

            if (char == '0') {
                zeroCount += 1
            } else {
                oneCount += 1
            }
        }

        return goDownCO2(
            inputs.toList().filter {
                if (oneCount == zeroCount) {
                    it[index] == '0'
                } else if (oneCount < zeroCount){
                    it[index] == '1'
                } else {
                    it[index] == '0'
                }
            },
            index + 1
        )
    }

}