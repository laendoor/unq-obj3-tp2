package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers._

trait CheckOperationSpec extends BaseSpec {

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

  "Check Subtractions" should s"$notContainProblems with valid operands" in {
    expectNoProblemsOnSub(2, 3)
    expectNoProblemsOnSub(5, 3)
    expectNoProblemsOnSub(0, 2)
  }

  it should s"$containRedundancyWarningMessage with Number(0) in second operand" in {
    expectSubZeroWarning(2, 0)
    expectSubZeroWarning(0, 0)
  }

  "Check Multiplications" should s"$notContainProblems with valid operands" in {
    expectNoProblemsOnMultiplication(2, 3)
    expectNoProblemsOnMultiplication(-1, 2)
  }

  it should s"$containRedundancyWarningMessage with Number(1) in at least one of the operands" in {
    expectMultiplyByOneWarning(1, 2)
    expectMultiplyByOneWarning(3, 1)
    expectMultiplyByOneWarning(1, 1)
    expectMultiplyByOneWarning(-2, 1)
  }

  it should s"$containRedundancyWarningMessage with Number(0) in ar least one of the operands" in {
    expectMultiplyByZeroWarning(0, 2)
    expectMultiplyByZeroWarning(3, 0)
    expectMultiplyByZeroWarning(0, 0)
    expectMultiplyByZeroWarning(-2, 0)
  }

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

  def expectRedundantOperationWarning(op: Operation, msg: String) = expectWarning(op, s"Redundant operation: $msg")
  def expectNoProblemsOnSum(x: Int, y: Int) = expectNoProblems(Sum(Number(x), Number(y)))
  def expectNoProblemsOnSub(x: Int, y: Int) = expectNoProblems(Subtraction(Number(x), Number(y)))
  def expectNoProblemsOnDivision(x: Int, y: Int)       = expectNoProblems(Division(Number(x), Number(y)))
  def expectNoProblemsOnMultiplication(x: Int, y: Int) = expectNoProblems(Multiplication(Number(x), Number(y)))

  def expectSumZeroWarning(x: Int, y: Int) = {
    expectRedundantOperationWarning(Sum(Number(x), Number(y)), "it is adding zero")
  }

  def expectSubZeroWarning(x: Int, y: Int) = {
    expectRedundantOperationWarning(Subtraction(Number(x), Number(y)), "it is subtracting zero")
  }

  def expectMultiplyByOneWarning(x: Int, y: Int) = {
    expectRedundantOperationWarning(Multiplication(Number(x), Number(y)), "it is multiplying by one")
  }

  def expectMultiplyByZeroWarning(x: Int, y: Int) = {
    expectRedundantOperationWarning(Multiplication(Number(x), Number(y)), "it is multiplying by zero")
  }

  def expectDivisionByOneWarning(x: Int, y: Int) = {
    expectRedundantOperationWarning(Division(Number(x), Number(y)), "it is dividing by one")
  }

  def expectDivisionByZeroError(x: Int, y: Int) = {
    expectError(
      Division(Number(x), Number(y)),
      "Invalid operation: it is dividing by zero"
    )
  }

}
