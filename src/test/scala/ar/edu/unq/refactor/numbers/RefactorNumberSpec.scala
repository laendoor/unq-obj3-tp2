package ar.edu.unq.refactor.numbers

import ar.edu.unq.{BaseSpec, RefactorWithAllRules}
import ar.edu.unq.program.{Number, Program}

trait RefactorNumberSpec extends BaseSpec {

  "Refactor Numbers" should "return same Numbers" in {
    val expressions = List(Number(-2), Number(-1), Number(0), Number(1), Number(2))
    val expectedProgram = Program(expressions)
    val program = RefactorWithAllRules(Program(expressions))

    program shouldBe expectedProgram
  }

}
