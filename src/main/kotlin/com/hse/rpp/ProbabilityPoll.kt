package com.hse.rpp

class ProbabilityPoll(arg1: String, arg2: String) {

    private var probFirst: MutableList<Double> = mutableListOf()

    fun addVoteForFirst(prob: Double): Boolean {
        probFirst.add(prob)
        return true
    }

    fun firstProb(): Double {
        var res = 0.0
        print(probFirst.lastIndex)
        for (i in 0..probFirst.lastIndex) {
            res += probFirst[i]
        }
        return res/(probFirst.lastIndex + 1)
    }

}