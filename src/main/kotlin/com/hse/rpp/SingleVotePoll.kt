package com.hse.rpp

class SingleVotePoll(val variants: List<String>) {

    constructor(vararg args: String) : this(listOf<String>(*args))

    private var votes = IntArray(variants.size)

    fun addVote(index: Int): Boolean {
        votes[index] += 1
        return true
    }

    fun winner(): String? {
        var maxIndex = -1
        var maxValue = 0
        var isDraw = true
        for (i in 0..variants.lastIndex) {
            if (votes[i] > maxValue) {
                maxValue = votes[i]
                maxIndex = i
                isDraw = false
            } else if (votes[i] == maxValue) {
                isDraw = true
            }
        }
        if (!isDraw) {
            return variants[maxIndex]
        }
        return null
    }
}