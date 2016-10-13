package ar.edu.unq.rules

import ar.edu.unq.problems._
import ar.edu.unq.program.AliasType._
import ar.edu.unq.program._

object CheckerOperationRules {
  val smart: CheckerRule = {
    case op: Sum => sumRule(op)
    case op: Subtraction => subtractionRule(op)
    case op: Division    => divisionRule(op)
    case op: Multiplication => multiplicationRule(op)
    case _ => None
  }

  val sumRule: CheckerRule = {
    case s @ Sum(Number(x), Number(y))
      if x == 0 || y == 0 => Some(SumZeroProblem(s))
    case _ => None
  }

  val subtractionRule: CheckerRule = {
    case s @Subtraction(_, Number(0)) => Some(SubZeroProblem(s))
    case _ => None
  }

  val divisionRule: CheckerRule = {
    case d @ Division(_, Number(1)) => Some(DivideByOneProblem(d))
    case d @ Division(_, Number(0)) => Some(DivideByZeroProblem(d))
    case _ => None
  }

  val multiplicationRule: CheckerRule = {
    case m @ Multiplication(Number(x), Number(y))
      if x == 1 || y == 1 => Some(MultiplyByOneProblem(m))
    case m @ Multiplication(Number(x), Number(y))
      if x == 0 || y == 0 => Some(MultiplyByZeroProblem(m))
    case _ => None
  }
}

object RefactorOperationRules {

  val smart: RefactorRule = {
    case op: Sum => sumRule(op)
    case op: Subtraction => subtractionRule(op)
    case op: Division    => divisionRule(op)
    case op: Multiplication => multiplicationRule(op)
    case expr => expr
  }

  val  sumRule: RefactorRule = {
    case Sum(Number(0), number) => number
    case Sum(number, Number(0)) => number
    case expr => expr
  }

  val subtractionRule: RefactorRule = {
    case Subtraction(number, Number(0)) => number
    case expr => expr
  }

  val divisionRule: RefactorRule = {
    case Division(number, Number(1)) => number
    case expr => expr
  }

  val multiplicationRule: RefactorRule = {
    case Multiplication(Number(0), number) => Number(0)
    case Multiplication(number, Number(0)) => Number(0)
    case Multiplication(Number(1), number) => number
    case Multiplication(number, Number(1)) => number
    case expr => expr
  }

  val expEquality: RefactorRule = {
    case e @ Equals(Number(x), Number(y)) if x == y => Boolean(true)
    case e @ Equals(Number(x), Number(y)) if x != y => Boolean(false)
  }

  val expInequality: RefactorRule = {
    case e @ Distinct(Number(x), Number(y)) if x == y => Boolean(false)
    case e @ Distinct(Number(x), Number(y)) if x != y => Boolean(true)
  }

  val expLesser: RefactorRule = {
    case e @ Lesser(Number(x), Number(y)) if x < y  => Boolean(true)
    case e @ Lesser(Number(x), Number(y)) if x >= y => Boolean(false)
  }

  val expGreater: RefactorRule = {
    case e @ Greater(Number(x), Number(y)) if x > y  => Boolean(true)
    case e @ Greater(Number(x), Number(y)) if x <= y => Boolean(false)
  }

  val expLesserOrEqual: RefactorRule = {
    case e @ LesserOrEqual(Number(x), Number(y)) if x <= y => Boolean(true)
    case e @ LesserOrEqual(Number(x), Number(y)) if x > y  => Boolean(false)
  }

  val expGreaterOrEqual: RefactorRule = {
    case e @ GreaterOrEqual(Number(x), Number(y)) if x >= y => Boolean(true)
    case e @ GreaterOrEqual(Number(x), Number(y)) if x < y  => Boolean(false)
  }

}

