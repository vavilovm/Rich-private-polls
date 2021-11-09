package com.hse.rpp

import kotlin.math.exp
import kotlin.math.ln

class ProbabilityPoll(val arg1: String, val arg2: String) {

    private var probFirst: MutableList<Double> = mutableListOf()

    fun addVoteForFirst(prob: Double): Boolean {
        probFirst.add(prob)
        return true
    }

    // TODO: proper averaging
    fun firstProb(): Double {
        var res = 0.0
        for (i in 0..probFirst.lastIndex) {
            res += ln(probFirst[i] / (1 - probFirst[i]))
        }
        return 1 - 1 / (1 + exp(res))
    }

    fun winner(): String? {
        val res = firstProb()
        if (res > 0.5) {
            return arg1
        } else {
            if (res < 0.5) {
                return arg2
            } else {
                return null
            }
        }
    }

}