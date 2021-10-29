package com.hse.rpp

class RankedPoll (val variantes: List<String>){

    private val votes: MutableList<Int> = MutableList(variantes.size) { 0 }

    constructor(vararg args: String): this(listOf<String>(*args))

    fun addVote(ind: Int){
        votes[ind] += 1
    }

    fun winner(): String{
        return variantes[votes.indices.maxByOrNull { votes[it] }!!]
    }
}