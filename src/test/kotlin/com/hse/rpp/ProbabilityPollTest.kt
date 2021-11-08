package com.hse.rpp

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ProbabilityPollTest {

    @Test
    fun `single vote poll`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        assertEquals(0.6, poll.firstProb())
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
        assertEquals(0.66, poll.firstProb(), 1e-4)
    }

    @Test
    fun `with winner poll`() {
        val poll = ProbabilityPoll("true", "false")
        poll.addVoteForFirst(0.6)
        assertEquals("true", poll.winner())
    }
}