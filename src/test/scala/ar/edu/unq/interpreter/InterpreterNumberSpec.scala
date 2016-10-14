package ar.edu.unq.interpreter

import ar.edu.unq.program.{Boolean, Interpreter, Number}
import ar.edu.unq.{BaseSpec, MkProgram}

trait InterpreterNumberSpec extends BaseSpec {

  "Interpret Number" should "return same Number" in {
    val value = Number(2)
    val result = Interpreter(MkProgram(value :: Nil))

    result shouldBe value
  }

  "Interpret nothing" should "return False" in {
    val result = Interpreter(MkProgram(Nil))

    result shouldBe Boolean(false)
  }

}
