package ar.edu.unq.refactor.numbers

import ar.edu.unq._
import ar.edu.unq.program.{Boolean, Program}

trait RefactorComparisionSpec extends BaseSpec {

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

  "Refactor Lesser" should "return True Booleans when first number is lesser than second" in {
    val expressions = List(MkLesser(0, 1), MkLesser(1, 2), MkLesser(2, 3))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when first number is greater or equal than second" in {
    val expressions = List(MkLesser(0, 0), MkLesser(1, 0), MkLesser(1, 1), MkLesser(2, 1))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(4)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor Greater" should "return True Booleans when first number is greater than second" in {
    val expressions = List(MkGreater(1, 0), MkGreater(2, 1), MkGreater(3, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when first number is lesser or equal than second" in {
    val expressions = List(MkGreater(0, 0), MkGreater(0, 1), MkGreater(1, 1), MkGreater(1, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(4)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor LesserOrEquals" should "return True Booleans when first number is lesser or equal than second" in {
    val expressions = List(MkLesserOrEqual(0, 0), MkLesserOrEqual(0, 1), MkLesserOrEqual(1, 1), MkLesserOrEqual(1, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(4)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when first number is greater than second" in {
    val expressions = List(MkLesserOrEqual(1, 0), MkLesserOrEqual(2, 1), MkLesserOrEqual(3, 2))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor GreaterOrEquals" should "return True Booleans when first number is greater or equal than second" in {
    val expressions = List(
      MkGreaterOrEqual(0, 0), MkGreaterOrEqual(1, 0),
      MkGreaterOrEqual(1, 1), MkGreaterOrEqual(2, 1)
    )
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(4)(Boolean(true))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return False Booleans when first number is lesser than second" in {
    val expressions = List(MkGreaterOrEqual(0, 1), MkGreaterOrEqual(1, 2), MkGreaterOrEqual(2, 3))
    val program = RefactorWithAllRules(Program(expressions))

    val expectedExpressions = List.fill(3)(Boolean(false))
    val expectedProgram = Program(expectedExpressions)

    program shouldBe expectedProgram
  }

}
