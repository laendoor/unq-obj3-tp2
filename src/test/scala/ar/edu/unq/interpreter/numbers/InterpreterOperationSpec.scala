package ar.edu.unq.interpreter.numbers

import ar.edu.unq._
import ar.edu.unq.program.{Interpreter, Number, Program}

trait InterpreterOperationSpec extends BaseSpec {

  "Interpret Sums" should "return resulting Number" in {
    Interpreter(Program(MkSum(2, 3)  :: Nil)) shouldBe Number(5)
    Interpreter(Program(MkSum(0, 0)  :: Nil)) shouldBe Number(0)
    Interpreter(Program(MkSum(-2, 3) :: Nil)) shouldBe Number(1)
  }


  "Interpret Subtractions" should "return resulting Number" in {
    Interpreter(Program(MkSubtraction(5, 1)  :: Nil)) shouldBe Number(4)
    Interpreter(Program(MkSubtraction(0, 0)  :: Nil)) shouldBe Number(0)
    Interpreter(Program(MkSubtraction(2, 3)  :: Nil)) shouldBe Number(-1)
    Interpreter(Program(MkSubtraction(-2, 3) :: Nil)) shouldBe Number(-5)
  }


  "Interpret Multiplications" should "return resulting Number" in {
    Interpreter(Program(MkMultiplication(5, 1)  :: Nil)) shouldBe Number(5)
    Interpreter(Program(MkMultiplication(0, 2)  :: Nil)) shouldBe Number(0)
    Interpreter(Program(MkMultiplication(2, 3)  :: Nil)) shouldBe Number(6)
    Interpreter(Program(MkMultiplication(-2, 3) :: Nil)) shouldBe Number(-6)
  }


  "Interpret Divisions" should "return resulting Number" in {
    Interpreter(Program(MkDivision(5, 1)  :: Nil)) shouldBe Number(5)
    Interpreter(Program(MkDivision(4, 2)  :: Nil)) shouldBe Number(2)
    Interpreter(Program(MkDivision(0, 2)  :: Nil)) shouldBe Number(0)
    Interpreter(Program(MkDivision(2, 3)  :: Nil)) shouldBe Number(0)
    Interpreter(Program(MkDivision(-2, 3) :: Nil)) shouldBe Number(0)
  }

}
