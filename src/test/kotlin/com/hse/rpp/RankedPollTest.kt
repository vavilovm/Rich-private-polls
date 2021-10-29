package com.hse.rpp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankedPollTest {

    @Test
    fun `single vote wins`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(0)
        assertEquals("asd", poll.winner())
    }

    @Test
    fun `single vote other winner`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(1)
        assertEquals("dsa", poll.winner())
    }

    @Test
    fun `multivote test`(){
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(listOf<Int>(1, 0, 2))
        poll.addVote(listOf<Int>(1, 2, 0))
        assertEquals("dsa", poll.winner())
    }

    @Test
    fun `multivote test 2`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(listOf<Int>(2, 0, 1))
        poll.addVote(listOf<Int>(2, 1, 0))
        assertEquals("dsa", poll.winner())
    }
}