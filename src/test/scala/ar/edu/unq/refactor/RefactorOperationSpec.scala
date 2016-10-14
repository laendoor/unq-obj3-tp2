package ar.edu.unq.refactor

import ar.edu.unq._
import ar.edu.unq.program.Number

trait RefactorOperationSpec extends BaseSpec {

  "Refactor Sums" should "return same Sums when contains not redundant operands" in {
    val expressions = List(MkSum(2, 3), MkSum(1, 4), MkSum(-1, 2))
    val expectedProgram = MkProgram(expressions)
    val program = RefactorWithAllRules(expectedProgram)

    program shouldBe expectedProgram
  }

  it should "return Numbers when one of operands is zero" in {
    val expressions = List(MkSum(2,  0), MkSum(0, -1), MkSum(0,  0))
    val program = RefactorWithAllRules(MkProgram(expressions))

    val expectedExpressions = List(Number(2), Number(-1), Number(0))
    val expectedProgram = MkProgram(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor Subtractions" should "return same Subtractions when contains not redundant operands" in {
    val expressions = List(MkSubtraction(2, 3), MkSubtraction(5, 3), MkSubtraction(0, 2))
    val expectedProgram = MkProgram(expressions)
    val program = RefactorWithAllRules(expectedProgram)

    program shouldBe expectedProgram
  }

  it should "return Numbers when right operands is zero" in {
    val expressions = List(MkSubtraction(2,  0), MkSubtraction(0,  0))
    val program = RefactorWithAllRules(MkProgram(expressions))

    val expectedExpressions = List(Number(2), Number(0))
    val expectedProgram = MkProgram(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor Multiplications" should "return same Multiplications when contains not redundant operands" in {
    val expressions = List(MkMultiplication(2,  3), MkMultiplication(-1, 2))
    val expectedProgram = MkProgram(expressions)
    val program = RefactorWithAllRules(expectedProgram)

    program shouldBe expectedProgram
  }

  it should "return Numbers when one of operands is number one" in {
    val expressions = List(
      MkMultiplication(1,  2), MkMultiplication(3,  1),
      MkMultiplication(1,  1), MkMultiplication(-2, 1)
    )
    val program = RefactorWithAllRules(MkProgram(expressions))

    val expectedExpressions = List(Number(2), Number(3), Number(1), Number(-2))
    val expectedProgram = MkProgram(expectedExpressions)

    program shouldBe expectedProgram
  }

  it should "return zero Numbers when one of operands is zero" in {
    val expressions = List(
      MkMultiplication(0, 2), MkMultiplication(3, 0),
      MkMultiplication(0,  0), MkMultiplication(-2, 0)
    )
    val program = RefactorWithAllRules(MkProgram(expressions))

    val expectedExpressions = List(Number(0), Number(0), Number(0), Number(0))
    val expectedProgram = MkProgram(expectedExpressions)

    program shouldBe expectedProgram
  }

  "Refactor Divisions" should "return same Divisions when contains not redundant operands" in {
    val expressions = List(MkDivision(4, 2), MkDivision(2, 3), MkDivision(-1, 2))
    val expectedProgram = MkProgram(expressions)
    val program = RefactorWithAllRules(expectedProgram)

    program shouldBe expectedProgram
  }

  it should "return dividen Numbers when divisors are number one" in {
    val expressions = List(MkDivision(1, 1), MkDivision(2, 1), MkDivision(-1, 1))
    val program = RefactorWithAllRules(MkProgram(expressions))

    val expectedExpressions = List(Number(1), Number(2), Number(-1))
    val expectedProgram = MkProgram(expectedExpressions)

    program shouldBe expectedProgram
  }

}
