package ar.edu.unq.interpreter.numbers

import ar.edu.unq._
import ar.edu.unq.program.{Interpreter, Program, Boolean}

trait InterpreterComparisionSpec extends BaseSpec {

  "Interpret Equals" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkEquals(1, 1) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkEquals(1, 2) :: Nil)) shouldBe Boolean(false)
  }


  "Interpret Distinct" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkDistinct(1, 2) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkDistinct(1, 1) :: Nil)) shouldBe Boolean(false)
  }

  "Interpret Lesser" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkLesser(1, 2) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkLesser(1, 1) :: Nil)) shouldBe Boolean(false)
    Interpreter(Program(MkLesser(2, 1) :: Nil)) shouldBe Boolean(false)
  }

  "Interpret Greater" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkGreater(2, 1) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkGreater(1, 1) :: Nil)) shouldBe Boolean(false)
    Interpreter(Program(MkGreater(1, 2) :: Nil)) shouldBe Boolean(false)
  }

  "Interpret LesserOrEquals" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkLesserOrEqual(1, 2) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkLesserOrEqual(1, 1) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkLesserOrEqual(2, 1) :: Nil)) shouldBe Boolean(false)
  }

  "Interpret GreaterOrEquals" should "return resulting Boolean comparison" in {
    Interpreter(Program(MkGreaterOrEqual(2, 1) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkGreaterOrEqual(1, 1) :: Nil)) shouldBe Boolean(true)
    Interpreter(Program(MkGreaterOrEqual(1, 2) :: Nil)) shouldBe Boolean(false)
  }

}
