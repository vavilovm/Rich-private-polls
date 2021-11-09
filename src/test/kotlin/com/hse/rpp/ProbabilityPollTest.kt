package com.hse.rpp

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

class ProbabilityPollTest {

    @Test
    fun `single vote poll`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        assertEquals(0.6, poll.firstProb(), 1e-4)
    }

    @Test
    fun `single vote poll 2`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.7)
        assertEquals(0.7, poll.firstProb())
    }

    @Test
    fun `two votes poll`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        poll.addVoteForFirst(0.4)
        assertEquals(0.5, poll.firstProb())
    }

    @Test
    fun `two votes with nonlinearity`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.8)
        poll.addVoteForFirst(0.33)
        assertEquals(0.66, poll.firstProb(), 1e-2)
    }

    @Test
    fun `with winner poll`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        assertEquals("true", poll.winner())
    }

    @Test
    fun `without winner poll`(){
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        poll.addVoteForFirst(0.4)
        assertNull(poll.winner())
    }

    @Test
    fun `many votes test`() {
        val poll = ProbabilityPoll("true", "false")
        for (i in 1..10000) {
            poll.addVoteForFirst(0.65)
            poll.addVoteForFirst(0.4)
        }
        assertEquals("true", poll.winner())
    }
}