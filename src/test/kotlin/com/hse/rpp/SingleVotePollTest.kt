package com.hse.rpp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SingleVotePollTest {
    @Test
    fun `single vote wins`() {
        val poll = SingleVotePoll("asd", "dsa", "sda")
        poll.addVote(0)
        Assertions.assertEquals("asd", poll.get_winner())
    }
}