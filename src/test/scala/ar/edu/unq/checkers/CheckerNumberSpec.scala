package ar.edu.unq.checkers

import ar.edu.unq.numbers.Number
import ar.edu.unq.{BaseSpec, Checker, Program}

trait CheckerNumberSpec extends BaseSpec {

  "Checker Number(2)" should "return Nil" in {
    val number  = Number(2)
    val program = Program(number :: Nil)

    Checker(program) shouldBe Nil
  }

}
