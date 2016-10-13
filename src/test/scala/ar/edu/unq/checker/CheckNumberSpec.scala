package ar.edu.unq.checker

import ar.edu.unq._
import ar.edu.unq.program.{Number, Program}

trait CheckNumberSpec extends BaseSpec {

  "Check Numbers" should "not contain problems" in {
    val expressions = List(Number(-2), Number(-1), Number(0), Number(1), Number(2))
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    expectedProblems shouldBe empty
  }

}
