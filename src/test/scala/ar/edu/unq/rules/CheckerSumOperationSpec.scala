package ar.edu.unq.rules

import ar.edu.unq.numbers.{Number, Sum}
import ar.edu.unq.program.{Program, Warning}
import ar.edu.unq.{BaseSpec, CheckAllRules}

trait CheckerSumOperationSpec extends BaseSpec {

  "Check Sum(Number(2), Number(3))" should "return Nil" in {
    val sum = Sum(Number(2), Number(3))
    val program = Program(sum :: Nil)

    CheckAllRules(program) shouldBe Nil
  }

  "Check Sum with at least one Number(0)" should "return Warning with message of redundancy" in {
    expectWarningWithSumOf(2, 0)
    expectWarningWithSumOf(0, -1)
    expectWarningWithSumOf(2, 0)
  }

  def expectWarningWithSumOf(x: Int, y: Int) = {
    val sum = Sum(Number(x), Number(y))
    val program = Program(sum :: Nil)
    val problems = CheckAllRules(program)

    problems.size shouldBe 1
    val problem = problems.head

    problem.severity   shouldBe Warning
    problem.message    shouldBe "[Warning] Redundant operation: it is adding zero"
    problem.expression shouldBe sum
  }

}
