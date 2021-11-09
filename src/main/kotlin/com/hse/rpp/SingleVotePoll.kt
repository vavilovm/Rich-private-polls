package com.hse.rpp

class SingleVotePoll(val variants: List<String>) {

    constructor(vararg args: String) : this(listOf<String>(*args))

    private var votes = IntArray(variants.size)

    fun addVote(index: Int): Boolean {
        votes[index] += 1
        return true
    }

    fun get_winner(): String? {
        var max_index = -1
        var max_value = 0
        var f = true
        for (i in 0..variants.size) {
            if (votes[i] > max_value) {
                max_value = votes[i]
                max_index = i
                f = false
            } else if (votes[i] == max_value) {
                f = true
            }
        }
        if (!f) {
            return variants[max_index]
        }
        return null
    }
}