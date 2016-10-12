package ar.edu.unq.checker.numbers

import ar.edu.unq._
import ar.edu.unq.checker._
import ar.edu.unq.numbers._
import ar.edu.unq.program.Program

trait CheckOperationSpec extends BaseSpec {

  "Check Sums" should "not contain problems with valid operands" in {
    val expressions = List(MkSum(2, 3), MkSum(1, 4), MkSum(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should "contain a warning problem and redundancy message with at least one Number(0)" in {
    val expressions = List(MkSum(2,  0), MkSum(0, -1), MkSum(0,  0))
    val problems    = expressions map SumZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Subtractions" should "not contain problems with valid operands" in {
    val expressions = List(MkSubtraction(2, 3), MkSubtraction(5, 3), MkSubtraction(0, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should "contain a warning problem and redundancy message with Number(0) in second operand" in {
    val expressions = List(MkSubtraction(2,  0), MkSubtraction(0,  0))
    val problems    = expressions map SubZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Multiplications" should "not contain problems with valid operands" in {
    val expressions = List(MkMultiplication(2,  3), MkMultiplication(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should "contain a warning problem and redundancy message with Number(1) in at least one of the operands" in {
    val expressions = List(
      MkMultiplication(1,  2), MkMultiplication(3,  1),
      MkMultiplication(1,  1), MkMultiplication(-2, 1)
    )
    val problems    = expressions map MultiplyByOneProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should "contain a warning problem and redundancy message with Number(0) in ar least one of the operands" in {
    val expressions = List(
      MkMultiplication(0, 2), MkMultiplication(3, 0),
      MkMultiplication(0,  0), MkMultiplication(-2, 0)
    )
    val problems    = expressions map MultiplyByZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  "Check Divisions" should "not contain problems valid operands" in {
    val expressions = List(MkDivision(4, 2), MkDivision(2, 3), MkDivision(-1, 2))
    val expectedProblems = CheckAllRules(Program(expressions))

    expectedProblems shouldBe empty
  }

  it should "contain a warning problem and redundancy message with Number(1) in divisor" in {
    val expressions = List(MkDivision(1, 1), MkDivision(2, 1), MkDivision(-1, 1))
    val problems    = expressions map DivideByOneProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should "contain an error problem and invalid operation message with Number(0) in divisor" in {
    val expressions = List(MkDivision(1, 0), MkDivision(2, 0), MkDivision(0, 0))
    val problems    = expressions map DivideByZeroProblem
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

}
