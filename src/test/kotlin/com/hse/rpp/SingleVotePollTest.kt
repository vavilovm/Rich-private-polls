package com.hse.rpp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SingleVotePollTest {
    @Test
    fun `single vote wins`() {
        val poll = SingleVotePoll("asd", "dsa", "sda")
        poll.addVote(0)
        Assertions.assertEquals("asd", poll.winner())
    }

    @Test
    fun `draw test 1`() {
        val poll = SingleVotePoll("true", "false")
        Assertions.assertNull(poll.winner())
    }

    @Test
    fun `draw test 2`() {
        val poll = SingleVotePoll("true", "false", "not stated")
        poll.addVote(0)
        poll.addVote(2)
        Assertions.assertNull(poll.winner())
    }
}