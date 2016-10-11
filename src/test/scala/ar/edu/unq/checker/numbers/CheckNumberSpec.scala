package ar.edu.unq.checker.numbers

import ar.edu.unq.checker.{BaseCheckerSpec, CheckAllRules}
import ar.edu.unq._
import ar.edu.unq.program.{Number, Program}

trait CheckNumberSpec extends BaseCheckerSpec {

  "Check Numbers" should notContainProblems in {
    val expressions = List(Number(-2), Number(-1), Number(0), Number(1), Number(2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

}
