package com.hse.rpp

class RankedPoll (val variantes: List<String>){

    private val votes: MutableList<List<Int>> = mutableListOf()
    private val iterationalList: MutableList<Int> = MutableList(variantes.size){0}
    private val currentIndexes: MutableList<Int> = MutableList(votes.size){0}

    constructor(vararg args: String): this(listOf<String>(*args))

    fun addVote(indexes: List<Int>){
        votes.add(indexes)
        currentIndexes.add(0)
    }

    fun addVote(ind: Int){
        this.addVote(listOf(ind))
    }

    fun winner(): String{
        for (i in 0 until votes.size){
            iterationalList[votes[i][currentIndexes[i]]] += 1
        }
        return variantes[iterationalList.indices.maxByOrNull { iterationalList[it] }!!]
    }
}