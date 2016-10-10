package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Division, Number}

trait CheckerDivOperationSpec extends BaseSpec {

  "Check Divisions" should s"$notContainProblems valid operands" in {
    expectNoProblemsOnDivision(4, 2)
    expectNoProblemsOnDivision(2, 3)
    expectNoProblemsOnDivision(-1, 2)
  }

  it should s"$containRedundancyWarningMessage with Number(1) in divisor" in {
    expectDivisionByOneWarning(1, 1)
    expectDivisionByOneWarning(2, 1)
    expectDivisionByOneWarning(-1, 1)
  }

  it should s"$containInvalidOperationErrorMessage with Number(0) in divisor" in {
    expectDivisionByZeroError(1, 0)
    expectDivisionByZeroError(2, 0)
    expectDivisionByZeroError(0, 0)
  }

  def expectNoProblemsOnDivision(x: Int, y: Int) = {
    expectNoProblems(Division(Number(x), Number(y)))
  }

  def expectDivisionByOneWarning(x: Int, y: Int) = {
    expectWarning(
      Division(Number(x), Number(y)),
      "Redundant operation: it is dividing by one"
    )
  }

  def expectDivisionByZeroError(x: Int, y: Int) = {
    expectError(
      Division(Number(x), Number(y)),
      "Invalid operation: it is dividing by zero"
    )
  }

}
