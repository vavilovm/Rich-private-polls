package com.hse

import com.hse.rpp.*
import java.lang.Math.random


fun main() {
  val firstValue = "true"
  val secondValue = "false"
  val poll = ProbabilityPoll(firstValue, secondValue)
  for (i in 1..20){
    val newProbability = random()
    poll.addVoteForFirst(newProbability)
    print("add $newProbability for $firstValue and ${1-newProbability} for $secondValue\n")
  }
  println()
  val winner = poll.winner()
  if (winner == null){
    print("It's draw!")
  } else {
    print("And the winner is: $winner")
  }
}