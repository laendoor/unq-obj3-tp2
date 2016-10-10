package ar.edu.unq.checker.numbers.operations

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Number, Subtraction}

trait CheckSubtractionSpec extends BaseSpec {

  "Check Subtractions" should s"$notContainProblems with valid operands" in {
    expectNoProblemsOnSub(2, 3)
    expectNoProblemsOnSub(5, 3)
    expectNoProblemsOnSub(0, 2)
  }

  it should s"$containRedundancyWarningMessage with Number(0) in second operand" in {
    expectSubZeroWarning(2, 0)
    expectSubZeroWarning(0, 0)
  }

  def expectNoProblemsOnSub(x: Int, y: Int) = {
    expectNoProblems(Subtraction(Number(x), Number(y)))
  }

  def expectSubZeroWarning(x: Int, y: Int) = {
    expectWarning(
      Subtraction(Number(x), Number(y)),
      "Redundant operation: it is subtracting zero"
    )
  }

}
