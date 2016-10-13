package ar.edu.unq.checker

import ar.edu.unq._
import ar.edu.unq.problems.DuplicatedVarProblem
import ar.edu.unq.program.{Number, Program}
import ar.edu.unq.vars.Var

trait CheckVarSpec extends BaseSpec {

  // a. Detectar cuando una variable está duplicada (dos con el mismo nombre)
  "Check Vars" should "detect when a Var definition is previously declared" in {

    val v1 = Var("foo")
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should "detect when a Var definition is previously instantiated" in {

    val v1 = Var("foo", Number(0))
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules(Program(expressions))

    problems.foreach(p => expectedProblems should contain (p))
  }

  it should "not generate duplicated var problem if Var instantiation is after than Var declaration" in {

    val v1 = Var("foo")
    val v2 = Var("foo", Number(0))
    val expressions = v1 :: v2 :: Nil

    CheckAllRules(Program(expressions)) shouldBe empty
  }

}
