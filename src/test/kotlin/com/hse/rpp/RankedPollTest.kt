package com.hse.rpp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
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
        poll.addVote(listOf(2, 1, 3))
        poll.addVote(listOf(3, 1, 2))
        assertEquals("dsa", poll.winner())
    }

    @Test
    fun `multivote test 2`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(listOf(2, 3, 1))
        poll.addVote(listOf(3, 2, 1))
        assertEquals("sda", poll.winner())
    }

    @Test
    fun `multivote test 3`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(listOf(1, 2, 3))
        poll.addVote(listOf(2, 1, 3))
        poll.addVote(listOf(3, 2, 1))
        assertEquals("dsa", poll.winner())
    }

    @Test
    fun `draw simple test`() {
        val poll = RankedPoll("asd", "dsa", "sda")
        poll.addVote(listOf(1, 2, 3))
        poll.addVote(listOf(2, 1, 3))
        assertNull(poll.winner())
    }
}