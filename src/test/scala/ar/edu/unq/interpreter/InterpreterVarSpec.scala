package ar.edu.unq.interpreter

import ar.edu.unq.program.{Interpreter, Number}
import ar.edu.unq.vars.{Assign, Ref, Var}
import ar.edu.unq.{BaseSpec, MkProgram}

trait InterpreterVarSpec extends BaseSpec {

  "Interpret Var" should "return nothing when it is just declared" in {
    val v = Var("foo")
    val result = Interpreter apply MkProgram(v :: Nil)

    result shouldBe None
  }

  it should "return its Value when is initialized" in {
    val v = Var("foo", Number(42))
    val result = Interpreter apply MkProgram(v :: Nil)

    result.get shouldBe Number(42)
  }

  it should "return its Value when is declared and then assigned" in {
    val result = Interpreter apply MkProgram(List(
      Var("foo"),
      Assign(Ref("foo"), Number(42)),
      Ref("foo")
    ))

    result.get shouldBe Number(42)
  }

}
