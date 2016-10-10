package ar.edu.unq.rules

import ar.edu.unq.numbers.{Number, Sub}
import ar.edu.unq.program.{Program, Warning}
import ar.edu.unq.{BaseSpec, CheckAllRules}

trait CheckerSubOperationSpec extends BaseSpec {

  "Check Sub(Number(2), Number(3))" should "return Nil" in {
    val sub = Sub(Number(2), Number(3))
    val program = Program(sub :: Nil)

    CheckAllRules(program) shouldBe Nil
  }

  "Check Sub(Number(0), Number(2))" should "return Nil" in {
    val sub = Sub(Number(0), Number(2))
    val program = Program(sub :: Nil)

    CheckAllRules(program) shouldBe Nil
  }

  "Check Sub with second operand Number(0)" should "return Warning with message of redundancy" in {
    expectWarningWithSubOf(2, 0)
    expectWarningWithSubOf(0, 0)
  }

  def expectWarningWithSubOf(x: Int, y: Int) = {
    val sub = Sub(Number(x), Number(y))
    val program = Program(sub :: Nil)
    val problems = CheckAllRules(program)

    problems.size shouldBe 1
    val problem = problems.head

    problem.severity   shouldBe Warning
    problem.message    shouldBe "[Warning] Redundant operation: it is subtracting zero"
    problem.expression shouldBe sub
  }

}
