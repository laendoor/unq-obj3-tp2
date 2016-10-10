package ar.edu.unq.checker.numbers.operations

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Number, Sum}

trait CheckerSumOperationSpec extends BaseSpec {

  "Check Sums" should s"$notContainProblems with valid operands" in {
    expectNoProblemsOnSum(2, 3)
    expectNoProblemsOnSum(1, 4)
    expectNoProblemsOnSum(-1, 2)
  }

  it should s"$containRedundancyWarningMessage with at least one Number(0)" in {
    expectSumZeroWarning(2, 0)
    expectSumZeroWarning(0, -1)
    expectSumZeroWarning(0, 0)
  }

  def expectNoProblemsOnSum(x: Int, y: Int) = {
    expectNoProblems(Sum(Number(x), Number(y)))
  }

  def expectSumZeroWarning(x: Int, y: Int) = {
    expectWarning(
      Sum(Number(x), Number(y)),
      "Redundant operation: it is adding zero"
    )
  }

}
