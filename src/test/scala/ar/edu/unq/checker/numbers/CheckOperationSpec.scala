package ar.edu.unq.checker.numbers

import ar.edu.unq.checker.{BaseCheckerSpec, CheckAllRules}
import ar.edu.unq.numbers._
import ar.edu.unq.program.Program

trait CheckOperationSpec extends BaseCheckerSpec {

  "Check Sums" should s"$notContainProblems with valid operands" in {
    val expressions = List(MkSum(2, 3), MkSum(1, 4), MkSum(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should s"$containRedundancyWarningMessage with at least one Number(0)" in {
    val expressions = List(MkSum(2,  0), MkSum(0, -1), MkSum(0,  0))
    val problems    = expressions map SumZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Subtractions" should s"$notContainProblems with valid operands" in {
    val expressions = List(MkSubtraction(2, 3), MkSubtraction(5, 3), MkSubtraction(0, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should s"$containRedundancyWarningMessage with Number(0) in second operand" in {
    val expressions = List(MkSubtraction(2,  0), MkSubtraction(0,  0))
    val problems    = expressions map SubZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Multiplications" should s"$notContainProblems with valid operands" in {
    val expressions = List(MkMultiplication(2,  3), MkMultiplication(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should s"$containRedundancyWarningMessage with Number(1) in at least one of the operands" in {
    val expressions = List(
      MkMultiplication(1,  2), MkMultiplication(3,  1),
      MkMultiplication(1,  1), MkMultiplication(-2, 1)
    )
    val problems    = expressions map MultiplyByOneProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should s"$containRedundancyWarningMessage with Number(0) in ar least one of the operands" in {
    val expressions = List(
      MkMultiplication(0, 2), MkMultiplication(3, 0),
      MkMultiplication(0,  0), MkMultiplication(-2, 0)
    )
    val problems    = expressions map MultiplyByZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Divisions" should s"$notContainProblems valid operands" in {
    val expressions = List(MkDivision(4, 2), MkDivision(2, 3), MkDivision(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should s"$containRedundancyWarningMessage with Number(1) in divisor" in {
    val expressions = List(MkDivision(1, 1), MkDivision(2, 1), MkDivision(-1, 1))
    val problems    = expressions map DivideByOneProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should s"$containInvalidOperationErrorMessage with Number(0) in divisor" in {
    val expressions = List(MkDivision(1, 0), MkDivision(2, 0), MkDivision(0, 0))
    val problems    = expressions map DivideByZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
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
