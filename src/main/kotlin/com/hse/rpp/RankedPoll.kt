package com.hse.rpp

const val NO_VOTE = 0

class RankedPoll (val variants: List<String>){

    private val votes: MutableList<List<Int>> = mutableListOf()

    constructor(vararg args: String): this(listOf<String>(*args))

    fun addVote(indexes: List<Int>){
        votes.add(indexes)
    }

    fun addVote(ind: Int){
        val vote = MutableList(variants.size) { NO_VOTE }
        vote[ind] = 1
        this.addVote(vote)
    }

    //https://en.wikipedia.org/wiki/Copeland%27s_method
    fun winner(): String? {
        val scores = MutableList(variants.size) { 0 }
        for (i in 0..variants.lastIndex) {
            for (j in (i + 1)..variants.lastIndex) {
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
        if (scores.filter { it == m }.size != 1) {
            return null
        }
        return variants[scores.indexOf(m)]
    }

    private fun pairwiseWinner(i: Int, j: Int): Int {
        var score = 0
        for (vote in votes) {
            val ix = vote[i]
            val jx = vote[j]
            when {
                ix == NO_VOTE || (jx != NO_VOTE && ix > jx) -> score += 1
                jx == NO_VOTE || (ix != NO_VOTE && ix < jx) -> score -= 1
            }
        }
        return score
    }
}