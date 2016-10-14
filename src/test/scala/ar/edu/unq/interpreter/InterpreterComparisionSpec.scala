package ar.edu.unq.interpreter

import ar.edu.unq._
import ar.edu.unq.program.{Boolean, Interpreter}

trait InterpreterComparisionSpec extends BaseSpec {

  "Interpret Equals" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkEquals(1, 1) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkEquals(1, 2) :: Nil)).get shouldBe Boolean(false)
  }


  "Interpret Distinct" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkDistinct(1, 2) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkDistinct(1, 1) :: Nil)).get shouldBe Boolean(false)
  }

  "Interpret Lesser" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkLesser(1, 2) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkLesser(1, 1) :: Nil)).get shouldBe Boolean(false)
    Interpreter(MkProgram(MkLesser(2, 1) :: Nil)).get shouldBe Boolean(false)
  }

  "Interpret Greater" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkGreater(2, 1) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkGreater(1, 1) :: Nil)).get shouldBe Boolean(false)
    Interpreter(MkProgram(MkGreater(1, 2) :: Nil)).get shouldBe Boolean(false)
  }

  "Interpret LesserOrEquals" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkLesserOrEqual(1, 2) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkLesserOrEqual(1, 1) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkLesserOrEqual(2, 1) :: Nil)).get shouldBe Boolean(false)
  }

  "Interpret GreaterOrEquals" should "return resulting Boolean comparison" in {
    Interpreter(MkProgram(MkGreaterOrEqual(2, 1) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkGreaterOrEqual(1, 1) :: Nil)).get shouldBe Boolean(true)
    Interpreter(MkProgram(MkGreaterOrEqual(1, 2) :: Nil)).get shouldBe Boolean(false)
  }

}
