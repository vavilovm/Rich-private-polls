package com.hse.rpp

class ProbabilityPoll(arg1: String, arg2: String) {

    private var probFirst: Double? = null

    fun addVoteForFirst(prob: Double): Boolean {
        probFirst = prob
        return true
    }

    fun firstProb(): Double {
        return probFirst ?: 0.0
    }

}