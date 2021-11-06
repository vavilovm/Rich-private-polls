package com.hse.rpp

class ProbabilityPoll(val variants: List<String>){

    constructor(arg1:String, arg2: String): this(listOf(arg1, arg2))

    fun addVoteForFirst(prob: Double): Boolean{
        return true
    }

    fun firstProb(): Double {
        return 0.6
    }

}