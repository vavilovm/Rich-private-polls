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

    //https://en.wikipedia.org/wiki/Copeland%27s_method
    fun winner(): String {
        val scores = MutableList(variantes.size) { 0 }
        for (i in 0..variantes.lastIndex) {
            for (j in (i + 1)..variantes.lastIndex) {
                val winner = pairwiseWinner(i, j)
                when {
                    winner < 0 -> scores[i] += 2
                    winner == 0 -> {
                        scores[i] += 1
                        scores[j] += 1
                    }
                    winner > 0 -> scores[j] += 2
                }
            }
        }
        val m = scores.maxOrNull()!!
        assert(scores.filter { it == m }.size == 1) //TODO: Handle ties
        return variantes[scores.indexOf(m)]
    }

    private fun pairwiseWinner(i: Int, j: Int): Int {
        var score = 0
        for (vote in votes) {
            //TODO: Change vote interface to avoid indexOf
            val ix = vote.indexOf(i)
            val jx = vote.indexOf(j)
            when {
                ix == -1 || (jx != -1 && ix > jx) -> score += 1
                jx == -1 || (ix != -1 && ix < jx) -> score -= 1
            }
        }
        return score
    }
}