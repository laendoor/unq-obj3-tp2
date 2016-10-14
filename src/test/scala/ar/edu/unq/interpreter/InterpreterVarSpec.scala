package ar.edu.unq.interpreter

import ar.edu.unq.program.Interpreter
import ar.edu.unq.vars.Var
import ar.edu.unq.{BaseSpec, MkProgram}

// e. Hacer que la "ejecución" del lenguaje incluya la ejecución de las variables.
trait InterpreterVarSpec extends BaseSpec {

  "Interpret Var-Definition" should "return nothing as result of program" in {
    val value  = Var("foo")
    val result = Interpreter apply MkProgram(value :: Nil)

    result shouldBe None
  }

//  "Interpret nothing" should "return False" in {
//    val result = Interpreter(MkProgram(Nil))
//
//    result shouldBe Boolean(false)
//  }

}
