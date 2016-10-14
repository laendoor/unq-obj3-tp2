package ar.edu.unq.checker

import ar.edu.unq._
import ar.edu.unq.problems._
import ar.edu.unq.program._
import ar.edu.unq.vars.{Assign, Ref, Var}

trait CheckVarSpec extends BaseSpec {

  // a. Detectar cuando una variable está duplicada (dos con el mismo nombre)
  "Check Vars" should "detect when a Var definition is previously declared" in {

    val v1 = Var("foo")
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "detect when a Var definition is previously instantiated" in {

    val v1 = Var("foo", Number(0))
    val v2 = Var("foo")
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect duplicated var problem if Var instantiation is after than Var declaration" in {

    val v1 = Var("foo")
    val v2 = Var("foo", Number(0))
    val expressions = v1 :: v2 :: Nil
    val problems    = DuplicatedVarProblem(v1) :: DuplicatedVarProblem(v2) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  // b. Detectar cuando una variable se usa "antes" de su declaración.
  it should "detect when a Var is Refer before its declaration" in {

    val r = Ref("foo")
    val v = Var("foo")
    val expressions = r :: v :: Nil
    val problems    = VarReferencedWithoutDeclaringProblem(r) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect var referenced without declaration problem if Var is Refer after its declarations" in {

    val v = Var("foo")
    val r = Ref("foo")
    val problems    = VarReferencedWithoutDeclaringProblem(r) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(List(v, r))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  // c. Detectar cuando una variable se declara y nunca se usa.
  it should "detect when a Var is declared but never used" in {

    val v = Var("foo")
    val expressions = v :: Number(0) :: Boolean(true) :: Nil
    val problems    = VarDeclaredButNeverUsedProblem(v) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Operations" in {

    val v0 = Var("0", Number(0))
    val v1 = Var("1", Number(1))
    val v2 = Var("2", Number(2))
    val v3 = Var("3", Number(3))
    val op0 = Sum(Ref("0"), Number(10))
    val op1 = Subtraction(Ref("1"), Number(-1))
    val op2 = Division(Number(2), Ref("2"))
    val op3 = Multiplication(Number(3), Ref("3"))
    val expressions = List(v0, v1, v2, v3, op0, op1, op2, op3)
    val problems    = List(
      VarDeclaredButNeverUsedProblem(v0),
      VarDeclaredButNeverUsedProblem(v1),
      VarDeclaredButNeverUsedProblem(v2),
      VarDeclaredButNeverUsedProblem(v3)
    )
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should "not detect var-declared-but-never-used-problem when a Var is declared and used in Comparisons" in {

    val v0 = Var("0", Number(0))
    val v1 = Var("1", Number(1))
    val v2 = Var("2", Number(2))
    val v3 = Var("3", Number(3))
    val v4 = Var("4", Number(4))
    val v5 = Var("5", Number(5))
    val cmp0 = Equals(Ref("0"), Number(10))
    val cmp1 = Distinct(Ref("1"), Number(-1))
    val cmp2 = Greater(Ref("2"), Number(2))
    val cmp3 = Lesser(Number(3), Ref("3"))
    val cmp4 = GreaterOrEqual(Number(3), Ref("4"))
    val cmp5 = LesserOrEqual(Number(3), Ref("5"))
    val expressions = List(v0, v1, v2, v3, v4, v5, cmp0, cmp1, cmp2, cmp3, cmp4, cmp5)
    val problems    = List(
      VarDeclaredButNeverUsedProblem(v0),
      VarDeclaredButNeverUsedProblem(v1),
      VarDeclaredButNeverUsedProblem(v2),
      VarDeclaredButNeverUsedProblem(v3),
      VarDeclaredButNeverUsedProblem(v4),
      VarDeclaredButNeverUsedProblem(v5)
    )
    val expectedProblems = CheckAllRules apply MkProgram(expressions)

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  // d. Detectar cuando variable se usa pero no esta asignada
  it should "detect when a var is referenced but not assigned" in {

    val v = Var("foo")
    val r = Ref("foo")
    val problems    = VarUsedButNeverAssignedProblem(r) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(List(v,r))

    problems foreach (p => expectedProblems should contain (p))
  }

  it should "not detect when a var reference was assigned on declaration" in {

    val v = Var("foo", Number(10))
    val r = Ref("foo")
    val problems    = VarUsedButNeverAssignedProblem(r) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(List(v,r))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

  it should "not detect when a var reference was assigned explicitly" in {

    val v = Var("foo")
    val a = Assign(Ref("foo"), Number(10))
    val r = Ref("foo")
    val problems    = VarUsedButNeverAssignedProblem(r) :: Nil
    val expectedProblems = CheckAllRules apply MkProgram(List(v,a,r))

    problems foreach (p => expectedProblems shouldNot contain (p))
  }

}
