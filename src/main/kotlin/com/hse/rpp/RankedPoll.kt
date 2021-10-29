package com.hse.rpp

class RankedPoll (val variantes: List<String>){

    constructor(vararg args: String): this(listOf<String>(*args)){}

    fun addVote(ind: Int){}

    fun winner(): String{
        return "asd";
    }
}