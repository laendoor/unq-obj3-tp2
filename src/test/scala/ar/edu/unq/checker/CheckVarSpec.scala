package ar.edu.unq.checker

import ar.edu.unq._
import ar.edu.unq.problems._
import ar.edu.unq.program._
import ar.edu.unq.vars.{Ref, Var}

trait CheckVarSpec extends BaseSpec {

  // a. Detectar cuando una variable está duplicada (dos con el mismo nombre)
  "Check Vars" should "detect when a Var definition is previously declared" in {

    val v1 = Var("foo")
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "detect when a Var definition is previously instantiated" in {

    val v1 = Var("foo", Number(0))
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect duplicated var problem if Var instantiation is after than Var declaration" in {

    val v1 = Var("foo")
    val v2 = Var("foo", Number(0))
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v1) :: DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  // b. Detectar cuando una variable se usa "antes" de su declaración.
  it should "detect when a Var is Refer before its declaration" in {

    val r = Ref("foo")
    val v = Var("foo")
    val expressions = r :: v :: Nil
    val problems    = VarReferencedWithoutDeclaringProblem(r) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect var referenced without declaration problem if Var is Refer after its declarations" in {

    val v = Var("foo")
    val r = Ref("foo")
    val expressions = v :: r :: Nil

    //CheckAllRules(MkProgram(expressions)) shouldBe empty
  }

  // c. Detectar cuando una variable se declara y nunca se usa.
  it should "detect when a Var is declared but never used" in {

    val v = Var("foo")
    val expressions = v :: Number(0) :: Boolean(true) :: Nil
    val problems    = VarDeclaredButNeverUsedProblem(v) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Sum" in {

    val v0 = Var("zero", Number(0))
    val v1 = Var("one", Number(1))
    val s0 = Sum(Ref("zero"), Number(10))
    val s1 = Sum(Number(2), Ref("one"))
    val expressions = List(v0, v1, s0, s1)
    val problems    = VarDeclaredButNeverUsedProblem(v0) :: VarDeclaredButNeverUsedProblem(v1) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Subtraction" in {

    val v0 = Var("zero", Number(0))
    val v1 = Var("one", Number(1))
    val s0 = Subtraction(Ref("zero"), Number(10))
    val s1 = Subtraction(Number(2), Ref("one"))
    val expressions = List(v0, v1, s0, s1)
    val problems    = VarDeclaredButNeverUsedProblem(v0) :: VarDeclaredButNeverUsedProblem(v1) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Division" in {

    val v0 = Var("zero", Number(0))
    val v1 = Var("one", Number(1))
    val s0 = Division(Ref("zero"), Number(10))
    val s1 = Division(Number(2), Ref("one"))
    val expressions = List(v0, v1, s0, s1)
    val problems    = VarDeclaredButNeverUsedProblem(v0) :: VarDeclaredButNeverUsedProblem(v1) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Multiplication" in {


    val v0 = Var("zero", Number(0))
    val v1 = Var("one", Number(1))
    val s0 = Multiplication(Ref("zero"), Number(10))
    val s1 = Multiplication(Number(2), Ref("one"))
    val expressions = List(v0, v1, s0, s1)
    val problems    = VarDeclaredButNeverUsedProblem(v0) :: VarDeclaredButNeverUsedProblem(v1) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  //D. Detectar cuando variable se usa pero no esta asignada
  it should " Variable declared unassigned" in {

    val v = Var("foo")
    val r = Ref("for")
    val v0 = Var("zero", Number(0))
    val expressions = List(v,r, v0)
    val problems    = VarDeclaredNotUnassigned(v) :: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should " Reference not Valid  in " in  {

    val r = Ref("foo")
    val t = Ref("fo")
    val expressions = List(r)
    val problems    = VarDeclaredReferenceNotValid(t):: Nil
    val expectedProblems = CheckAllRules(MkProgram(expressions))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }
}
