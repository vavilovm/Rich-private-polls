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

}