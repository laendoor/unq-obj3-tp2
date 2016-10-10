package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object OperationRules {
  val sumZero: Rule = {
    case s @ Sum(Number(x), Number(y))
      if x == 0 || y == 0 => Some(SumZeroProblem(s))
    case _ => None
  }

  val subZero: Rule = {
    case s @Subtraction(_, Number(0)) => Some(SubZeroProblem(s))
    case _ => None
  }

  val divideByOne: Rule = {
    case d @ Division(_, Number(1)) => Some(DivideByOneProblem(d))
    case _ => None
  }

  val divideByZero: Rule = {
    case d @ Division(_, Number(0)) => Some(DivideByZeroProblem(d))
    case _ => None
  }

  val multiplyByOne: Rule = {
    case m @ Multiplication(Number(x), Number(y))
      if x == 1 || y == 1 => Some(MultiplyByOneProblem(m))
    case _ => None
  }

  val multiplyByZero: Rule = {
    case m @ Multiplication(Number(x), Number(y))
      if x == 0 || y == 0 => Some(MultiplyByZeroProblem(m))
    case _ => None
  }
}

object RefactorOperationRules {
  val  expSum: RefactorRules = {
    case s @Sum(Number(0),a) => a
    case s @Sum(a,Number(0)) => a
    case s @Sum(_,_) => s
  }

  val expSub: RefactorRules = {
    case s @Subtraction(a,Number(0)) => a
    case s @Subtraction(_,_) => s
  }

  val expDivide: RefactorRules = {
    case s @Division(a,Number(0)) => a
    case s @Division(_,_) => s
  }

  val expMul: RefactorRules = {
    case s @Multiplication(Number(0),a) => a
    case s @Multiplication(a,Number(0)) => a
    case s @Multiplication(Number(1),a) => a
    case s @Multiplication(a,Number(1)) => a
    case s @Multiplication(_,_) => s
  }

  val expEquality: RefactorRules = {
    case e @ Equals(Number(x), Number(y)) if x == y => TRUE()
    case e @ Equals(Number(x), Number(y)) if x != y => FALSE()
  }

  val expInequality: RefactorRules = {
    case e @ Distinct(Number(x), Number(y)) if x == y => FALSE()
    case e @ Distinct(Number(x), Number(y)) if x != y => TRUE()
  }

  val expLesser: RefactorRules = {
    case e @ Lesser(Number(x), Number(y)) if x < y  => TRUE()
    case e @ Lesser(Number(x), Number(y)) if x >= y => FALSE()
  }

  val expGreater: RefactorRules = {
    case e @ Greater(Number(x), Number(y)) if x > y  => TRUE()
    case e @ Greater(Number(x), Number(y)) if x <= y => FALSE()
  }

  val expLesserOrEqual: RefactorRules = {
    case e @ LesserOrEqual(Number(x), Number(y)) if x <= y => TRUE()
    case e @ LesserOrEqual(Number(x), Number(y)) if x > y  => FALSE()

  }

  val expGreaterOrEqual: RefactorRules = {
    case e @ GreaterOrEqual(Number(x), Number(y)) if x >= y => TRUE()
    case e @ GreaterOrEqual(Number(x), Number(y)) if x < y  => FALSE()

  }

}

