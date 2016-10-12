package ar.edu.unq.checker.numbers

import ar.edu.unq._
import ar.edu.unq.program.{Number, Program}

trait CheckNumberSpec extends BaseSpec {

  "Check Numbers" should "not contain problems" in {
    val expressions = List(Number(-2), Number(-1), Number(0), Number(1), Number(2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

}
