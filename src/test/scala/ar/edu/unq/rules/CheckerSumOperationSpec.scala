package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Number, Sum}

trait CheckerSumOperationSpec extends BaseSpec {

  "Check valid Sums" should "return Nil" in {
    expectNoProblemsOnSum(2, 3)
    expectNoProblemsOnSum(1, 4)
    expectNoProblemsOnSum(-1, 2)
  }

  "Check Sum with at least one Number(0)" should "return Warning with message of redundancy" in {
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
