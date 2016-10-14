package ar.edu.unq.refactor

import ar.edu.unq.program.Number
import ar.edu.unq.{BaseSpec, MkProgram, RefactorWithAllRules}

trait RefactorNumberSpec extends BaseSpec {

  "Refactor Numbers" should "return same Numbers" in {
    val expressions = List(Number(-2), Number(-1), Number(0), Number(1), Number(2))
    val expectedProgram = MkProgram(expressions)
    val program = RefactorWithAllRules(MkProgram(expressions))

    program shouldBe expectedProgram
  }

}
