package ar.edu.unq.interpreter

import ar.edu.unq._
import ar.edu.unq.program.{Interpreter, Number}

trait InterpreterOperationSpec extends BaseSpec {

  "Interpret Sums" should "return resulting Number" in {
    Interpreter(MkProgram(MkSum(2, 3)   :: Nil)).get shouldBe Number(5)
    Interpreter(MkProgram(MkSum(0, 0)   :: Nil)).get shouldBe Number(0)
    Interpreter(MkProgram(MkSum(-2, 3)  :: Nil)).get shouldBe Number(1)
    Interpreter(MkProgram(MkSum(-2, -3) :: Nil)).get shouldBe Number(-5)
  }


  "Interpret Subtractions" should "return resulting Number" in {
    Interpreter(MkProgram(MkSubtraction(5, 1)  :: Nil)).get shouldBe Number(4)
    Interpreter(MkProgram(MkSubtraction(0, 0)  :: Nil)).get shouldBe Number(0)
    Interpreter(MkProgram(MkSubtraction(2, 3)  :: Nil)).get shouldBe Number(-1)
    Interpreter(MkProgram(MkSubtraction(-2, 3) :: Nil)).get shouldBe Number(-5)
  }


  "Interpret Multiplications" should "return resulting Number" in {
    Interpreter(MkProgram(MkMultiplication(5, 1)  :: Nil)).get shouldBe Number(5)
    Interpreter(MkProgram(MkMultiplication(0, 2)  :: Nil)).get shouldBe Number(0)
    Interpreter(MkProgram(MkMultiplication(2, 3)  :: Nil)).get shouldBe Number(6)
    Interpreter(MkProgram(MkMultiplication(-2, 3) :: Nil)).get shouldBe Number(-6)
  }


  "Interpret Divisions" should "return resulting Number" in {
    Interpreter(MkProgram(MkDivision(5, 1)  :: Nil)).get shouldBe Number(5)
    Interpreter(MkProgram(MkDivision(4, 2)  :: Nil)).get shouldBe Number(2)
    Interpreter(MkProgram(MkDivision(0, 2)  :: Nil)).get shouldBe Number(0)
    Interpreter(MkProgram(MkDivision(2, 3)  :: Nil)).get shouldBe Number(0)
    Interpreter(MkProgram(MkDivision(-2, 3) :: Nil)).get shouldBe Number(0)
  }

}
