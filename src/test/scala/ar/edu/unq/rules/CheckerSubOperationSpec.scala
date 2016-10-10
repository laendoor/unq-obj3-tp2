package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Number, Sub}

trait CheckerSubOperationSpec extends BaseSpec {

  "Check valid Subs" should "return Nil" in {
    expectNoProblemsOnSub(2, 3)
    expectNoProblemsOnSub(0, 2)
  }

  "Check Sub with second operand Number(0)" should "return Warning with message of redundancy" in {
    expectSubZeroWarning(2, 0)
    expectSubZeroWarning(0, 0)
  }

  def expectNoProblemsOnSub(x: Int, y: Int) = {
    expectNoProblems(Sub(Number(x), Number(y)))
  }

  def expectSubZeroWarning(x: Int, y: Int) = {
    expectWarning(
      Sub(Number(x), Number(y)),
      "Redundant operation: it is subtracting zero"
    )
  }

}
