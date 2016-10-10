package ar.edu.unq.rules

import ar.edu.unq.numbers.Number
import ar.edu.unq.program.Program
import ar.edu.unq.{BaseSpec, CheckAllRules}

trait CheckerNumberSpec extends BaseSpec {

  "Check Number(2)" should "return Nil" in {
    val number  = Number(2)
    val program = Program(number :: Nil)

    CheckAllRules(program) shouldBe Nil
  }

}
