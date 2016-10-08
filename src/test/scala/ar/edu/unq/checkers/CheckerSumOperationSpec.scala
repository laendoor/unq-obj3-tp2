package ar.edu.unq.checkers

import ar.edu.unq.numbers.{Number, Sum}
import ar.edu.unq.{BaseSpec, Checker, Program, Warning}

trait CheckerSumOperationSpec extends BaseSpec {

  "Check Sum(Number(2), Number(3))" should "return Nil" in {
    val sum = Sum(Number(2), Number(3))
    val program = Program(sum :: Nil)

    Checker(program) shouldBe Nil
  }

  "Check Sum(Number(2), Number(0))" should "return Warning with message of redundancy" in {
    val sum = Sum(Number(2), Number(0))
    val program = Program(sum :: Nil)
    val problems = Checker(program)

    problems.size shouldBe 1
    val problem = problems.head

    problem.severity   shouldBe Warning
    problem.message    shouldBe "[Warning] Redundant operation: it is adding zero"
    problem.expression shouldBe sum
  }

}
