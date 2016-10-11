package ar.edu.unq.refactor.numbers

import ar.edu.unq._
import ar.edu.unq.checker._
import ar.edu.unq.numbers._
import ar.edu.unq.program.{Number, Program, Boolean}
import ar.edu.unq.refactor.{BaseRefactorSpec, RefactorWithAllRules}

trait RefactorComparisionSpec extends BaseRefactorSpec {

  "Refactor Equals" should "return True Booleans when compared numbers are equals" in {
    val expressions = List(MkEquals(0, 0), MkEquals(1, 1), MkEquals(2, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when compared numbers are different" in {
    val expressions = List(
      MkEquals(0, 1), MkEquals(1, 2), MkEquals(2, 3),
      MkEquals(3, 2), MkEquals(2, 1), MkEquals(1, 0)
    )
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(6)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor Distinct" should "return True Booleans when compared numbers are different" in {
    val expressions = List(
      MkDistinct(0, 1), MkDistinct(1, 2), MkDistinct(2, 3),
      MkDistinct(3, 2), MkDistinct(2, 1), MkDistinct(1, 0)
    )
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(6)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when compared numbers are equals" in {
    val expressions = List(MkDistinct(0, 0), MkDistinct(1, 1), MkDistinct(2, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

//  "Refactor Lesser" should "$containAlwaysTrueComparisionWarningMessage if first number is lesser than second" in {
//    val expressions = List(MkLesser(0, 1), MkLesser(1, 2), MkLesser(2, 3))
//    val problems = expressions map TrueComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  it should "$containAlwaysFalseComparisionWarningMessage if first number is greater-or-equals than second" in {
//    val expressions = List(MkLesser(0, 0), MkLesser(1, 0), MkLesser(1, 1), MkLesser(2, 1))
//    val problems = expressions map FalseComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  "Refactor Greater" should "$containAlwaysTrueComparisionWarningMessage if first number is greater than second" in {
//    val expressions = List(MkGreater(1, 0), MkGreater(2, 1), MkGreater(3, 2))
//    val problems = expressions map TrueComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  it should "$containAlwaysFalseComparisionWarningMessage if first number is lesser-or-equals than second" in {
//    val expressions = List(MkGreater(0, 0), MkGreater(0, 1), MkGreater(1, 1), MkGreater(1, 2))
//    val problems = expressions map FalseComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  "Refactor LesserOrEquals" should "$containAlwaysTrueComparisionWarningMessage if first number is lesser-or-equal than second" in {
//    val expressions = List(MkLesserOrEqual(0, 0), MkLesserOrEqual(0, 1), MkLesserOrEqual(1, 1), MkLesserOrEqual(1, 2))
//    val problems = expressions map TrueComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  it should "$containAlwaysFalseComparisionWarningMessage if first number is greater than second" in {
//    val expressions = List(MkLesserOrEqual(1, 0), MkLesserOrEqual(2, 1), MkLesserOrEqual(3, 2))
//    val problems = expressions map FalseComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  "Refactor GreaterOrEquals" should "$containAlwaysTrueComparisionWarningMessage if first number is greater-or-equal than second" in {
//    val expressions = List(
//      MkGreaterOrEqual(0, 0), MkGreaterOrEqual(1, 0),
//      MkGreaterOrEqual(1, 1), MkGreaterOrEqual(2, 1)
//    )
//    val problems = expressions map TrueComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }
//
//  it should "$containAlwaysFalseComparisionWarningMessage if first number is lesser than second" in {
//    val expressions = List(MkGreaterOrEqual(0, 1), MkGreaterOrEqual(1, 2), MkGreaterOrEqual(2, 3))
//    val problems = expressions map FalseComparisonProblem
//    val expectedProblems = CheckAllRules(Program(expressions))
//
//    problems.foreach(p => expectedProblems should contain (p))
//  }

}
