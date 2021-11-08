package com.hse.rpp

class ProbabilityPoll(val arg1: String, val arg2: String) {

    private var probFirst: MutableList<Double> = mutableListOf()

    fun addVoteForFirst(prob: Double): Boolean {
        probFirst.add(prob)
        return true
    }

    // TODO: proper averaging
    fun firstProb(): Double {
        var res = 0.0
        print(probFirst.lastIndex)
        for (i in 0..probFirst.lastIndex) {
            res += probFirst[i]
        }
        return res/(probFirst.lastIndex + 1)
    }

    fun winner(): String = if(firstProb() >= 0.5) arg1 else arg2

}