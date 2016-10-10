package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Multiplication, Number}

trait CheckerMulOperationSpec extends BaseSpec {

  "Check valid Multiplications" should "not return Problems" in {
    expectNoProblemsOnMultiplication(2, 3)
    expectNoProblemsOnMultiplication(-1, 2)
  }

  "Check Multiplications with at least one 1 as operand" should "return Warning with message of redundancy" in {
    expectMultiplyByOneWarning(1, 2)
    expectMultiplyByOneWarning(3, 1)
    expectMultiplyByOneWarning(1, 1)
    expectMultiplyByOneWarning(-2, 1)
  }

  "Check Multiplications with at least one 0 as operand" should "return Warning with message of redundancy" in {
    expectMultiplyByZeroWarning(0, 2)
    expectMultiplyByZeroWarning(3, 0)
    expectMultiplyByZeroWarning(0, 0)
    expectMultiplyByZeroWarning(-2, 0)
  }

  def expectNoProblemsOnMultiplication(x: Int, y: Int) = {
    expectNoProblems(Multiplication(Number(x), Number(y)))
  }

  def expectMultiplyByOneWarning(x: Int, y: Int) = {
    expectWarning(
      Multiplication(Number(x), Number(y)),
      "Redundant operation: it is multiplying by one"
    )
  }

  def expectMultiplyByZeroWarning(x: Int, y: Int) = {
    expectWarning(
      Multiplication(Number(x), Number(y)),
      "Redundant operation: it is multiplying by zero"
    )
  }

}
