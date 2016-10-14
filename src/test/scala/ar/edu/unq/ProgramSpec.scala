package ar.edu.unq

import ar.edu.unq.program._
import ar.edu.unq.vars.{Assign, Ref, Var}

class ProgramSpec extends BaseSpec {

  "Interpret Program" should "return a result" in {
    val result = Interpreter apply MkProgram(List(
      Var("foo", Number(10)),
      Var("init", Number(0)),
      Assign(Ref("sum"), Sum(Ref("init"), Number(42))),           // 42
      Assign(Ref("sub"), Subtraction(Number(50), Ref("sum"))),    //  8
      Assign(Ref("div"), Division(Ref("sub"), Number(2))),        //  4
      Assign(Ref("mul"), Multiplication(Ref("div"), Ref("foo"))), // 40
      Assign(Ref("res"), Sum(Number(2), Ref("mul"))),             // 42
      Ref("res")
    ))

    result.get shouldBe Number(42)
  }
}