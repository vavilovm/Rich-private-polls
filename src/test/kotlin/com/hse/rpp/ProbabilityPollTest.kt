package com.hse.rpp

import org.junit.Test
import org.junit.jupiter.api.Assertions

class ProbabilityPollTest {

    @Test
    fun `single vote poll`() {
        val poll = RankedPoll()
        poll.addVoteForFirst(0.6)
        Assertions.assertEquals(0.6, poll.firstProb())
    }
}