package com.cameronjump.advent

import android.widget.TextView

class SolverDay02 {

    private fun partOne() {
        val input = ""//getString(R.string.day_02_input_a)

        val commands = mutableListOf<Command>()
        val values = mutableListOf<Int>()
        input.split(" ").forEach {
            try {
                val command = Command.valueOf(it.trim())
                commands.add(command)
            } catch (e: Exception) {
                //
            }

            try {
                val value = Integer.parseInt(it.trim())
                values.add(value)
            } catch (e: Exception) {
                //
            }
        }

        var horizontal = 0
        var depth = 0

        for (i in 0 until commands.size) {
            val command = commands[i]

            when (command) {
                Command.down -> depth += values[i]
                Command.forward -> horizontal += values[i]
                Command.up -> depth -= values[i]
            }
        }

        val answer = depth * horizontal
//        findViewById<TextView>(R.id.firstAnswer).apply {
//            text = answer.toString()
//        }
    }

    enum class Command {
        down,
        forward,
        up
    }

    private fun partTwo() {
        val input = ""//getString(R.string.day_02_input_a)

        val commands = mutableListOf<Command>()
        val values = mutableListOf<Int>()
        input.split(" ").forEach {
            try {
                val command = Command.valueOf(it.trim())
                commands.add(command)
            } catch (e: Exception) {
                //
            }

            try {
                val value = Integer.parseInt(it.trim())
                values.add(value)
            } catch (e: Exception) {
                //
            }
        }

        var horizontal = 0
        var depth = 0
        var aim = 0

        for (i in 0 until commands.size) {
            val command = commands[i]

            when (command) {
                Command.down -> aim += values[i]
                Command.forward -> {
                    horizontal += values[i]
                    depth += aim * values[i]
                }
                Command.up -> aim -= values[i]
            }
        }

        val answer = depth * horizontal
//        findViewById<TextView>(R.id.secondAnswer).apply {
//            text = answer.toString()
//        }
    }

}