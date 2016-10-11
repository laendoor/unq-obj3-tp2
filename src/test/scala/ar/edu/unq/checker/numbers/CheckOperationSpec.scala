package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.checker.BaseCheckerSpec
import ar.edu.unq.numbers._

trait CheckOperationSpec extends BaseCheckerSpec {

  "Check Sums" should s"$notContainProblems with valid operands" in {
    expectNoProblems(MkSum(2, 3))
    expectNoProblems(MkSum(1, 4))
    expectNoProblems(MkSum(-1, 2))
  }

  it should s"$containRedundancyWarningMessage with at least one Number(0)" in {
    expectRedundantOperationWarning(MkSum(2,  0), "it is adding zero")
    expectRedundantOperationWarning(MkSum(0, -1), "it is adding zero")
    expectRedundantOperationWarning(MkSum(0,  0), "it is adding zero")
  }

  "Check Subtractions" should s"$notContainProblems with valid operands" in {
    expectNoProblems(MkSubtraction(2, 3))
    expectNoProblems(MkSubtraction(5, 3))
    expectNoProblems(MkSubtraction(0, 2))
  }

  it should s"$containRedundancyWarningMessage with Number(0) in second operand" in {
    expectRedundantOperationWarning(MkSubtraction(2,  0), "it is subtracting zero")
    expectRedundantOperationWarning(MkSubtraction(0,  0), "it is subtracting zero")
  }

  "Check Multiplications" should s"$notContainProblems with valid operands" in {
    expectNoProblems(MkMultiplication(2,  3))
    expectNoProblems(MkMultiplication(-1, 2))
  }

  it should s"$containRedundancyWarningMessage with Number(1) in at least one of the operands" in {
    expectRedundantOperationWarning(MkMultiplication(1,  2), "it is multiplying by one")
    expectRedundantOperationWarning(MkMultiplication(3,  1), "it is multiplying by one")
    expectRedundantOperationWarning(MkMultiplication(1,  1), "it is multiplying by one")
    expectRedundantOperationWarning(MkMultiplication(-2, 1), "it is multiplying by one")
  }

  it should s"$containRedundancyWarningMessage with Number(0) in ar least one of the operands" in {
    expectRedundantOperationWarning(MkMultiplication(0,  2), "it is multiplying by zero")
    expectRedundantOperationWarning(MkMultiplication(3,  0), "it is multiplying by zero")
    expectRedundantOperationWarning(MkMultiplication(0,  0), "it is multiplying by zero")
    expectRedundantOperationWarning(MkMultiplication(-2, 0), "it is multiplying by zero")
  }

  "Check Divisions" should s"$notContainProblems valid operands" in {
    expectNoProblems(MkDivision(4, 2))
    expectNoProblems(MkDivision(2, 3))
    expectNoProblems(MkDivision(-1, 2))
  }

  it should s"$containRedundancyWarningMessage with Number(1) in divisor" in {
    expectRedundantOperationWarning(MkDivision( 1, 1), "it is dividing by one")
    expectRedundantOperationWarning(MkDivision( 2, 1), "it is dividing by one")
    expectRedundantOperationWarning(MkDivision(-1, 1), "it is dividing by one")
  }

  it should s"$containInvalidOperationErrorMessage with Number(0) in divisor" in {
    expectInvalidOperationError(MkDivision(1, 0), "it is dividing by zero")
    expectInvalidOperationError(MkDivision(2, 0), "it is dividing by zero")
    expectInvalidOperationError(MkDivision(0, 0), "it is dividing by zero")
  }

  def expectRedundantOperationWarning(op: Operation, msg: String) = {
    expectWarning(op, s"Redundant operation: $msg")
  }

  def expectInvalidOperationError(op: Operation, msg: String) = {
    expectError(op, s"Invalid operation: $msg")
  }

}

object MkSum {
  def apply(x: Int, y: Int) = Sum(Number(x), Number(y))
}

object MkSubtraction {
  def apply(x: Int, y: Int) = Subtraction(Number(x), Number(y))
}

object MkMultiplication {
  def apply(x: Int, y: Int) = Multiplication(Number(x), Number(y))
}

object MkDivision {
  def apply(x: Int, y: Int) = Division(Number(x), Number(y))
}
