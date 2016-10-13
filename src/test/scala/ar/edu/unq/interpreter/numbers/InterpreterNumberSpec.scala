package ar.edu.unq.interpreter.numbers

import ar.edu.unq.program.{Boolean, Interpreter, Number, Program}
import ar.edu.unq.BaseSpec

trait InterpreterNumberSpec extends BaseSpec {

  "Interpret Number" should "return same Number" in {
    val value = Number(2)
    val result = Interpreter(Program(value :: Nil))

    result shouldBe value
  }

  "Interpret nothing" should "return False" in {
    val result = Interpreter(Program(Nil))

    result shouldBe Boolean(false)
  }

}
