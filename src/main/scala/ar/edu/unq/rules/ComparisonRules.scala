package ar.edu.unq.rules

import ar.edu.unq.problems._
import ar.edu.unq.program.AliasType._
import ar.edu.unq.program._

object CheckerComparisonRules {
  val smart: CheckerRule = {
    case op: Equals   => equality(op)
    case op: Distinct => inequality(op)
    case op: Lesser   => lesser(op)
    case op: Greater  => greater(op)
    case op: LesserOrEqual  => lesserOrEqual(op)
    case op: GreaterOrEqual => greaterOrEqual(op)
    case _ => None
  }

  val equality: CheckerRule = {
    case e @ Equals(Number(x), Number(y)) if x == y => Some(TrueComparisonProblem(e))
    case e @ Equals(Number(x), Number(y)) if x != y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val inequality: CheckerRule = {
    case e @ Distinct(Number(x), Number(y)) if x == y => Some(FalseComparisonProblem(e))
    case e @ Distinct(Number(x), Number(y)) if x != y => Some(TrueComparisonProblem(e))
    case _ => None
  }

  val lesser: CheckerRule = {
    case e @ Lesser(Number(x), Number(y)) if x < y  => Some(TrueComparisonProblem(e))
    case e @ Lesser(Number(x), Number(y)) if x >= y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val greater: CheckerRule = {
    case e @ Greater(Number(x), Number(y)) if x > y  => Some(TrueComparisonProblem(e))
    case e @ Greater(Number(x), Number(y)) if x <= y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val lesserOrEqual: CheckerRule = {
    case e @ LesserOrEqual(Number(x), Number(y)) if x <= y => Some(TrueComparisonProblem(e))
    case e @ LesserOrEqual(Number(x), Number(y)) if x > y  => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val greaterOrEqual: CheckerRule = {
    case e @ GreaterOrEqual(Number(x), Number(y)) if x >= y => Some(TrueComparisonProblem(e))
    case e @ GreaterOrEqual(Number(x), Number(y)) if x < y  => Some(FalseComparisonProblem(e))
    case _ => None
  }
}

object RefactorComparisonRules {

  val smart: RefactorRule = {
    case op: Equals   => equality(op)
    case op: Distinct => inequality(op)
    case op: Lesser   => lesser(op)
    case op: Greater  => greater(op)
    case op: LesserOrEqual  => lesserOrEqual(op)
    case op: GreaterOrEqual => greaterOrEqual(op)
    case expr => expr
  }

  val equality: RefactorRule = {
    case Equals(Number(x), Number(y)) => Boolean(x == y)
    case expr => expr
  }

  val inequality: RefactorRule = {
    case Distinct(Number(x), Number(y)) => Boolean(x != y)
    case expr => expr
  }

  val lesser: RefactorRule = {
    case Lesser(Number(x), Number(y)) => Boolean(x < y)
    case expr => expr
  }

  val greater: RefactorRule = {
    case Greater(Number(x), Number(y)) => Boolean(x > y)
    case expr => expr
  }

  val lesserOrEqual: RefactorRule = {
    case LesserOrEqual(Number(x), Number(y)) => Boolean(x <= y)
    case expr => expr
  }

  val greaterOrEqual: RefactorRule = {
    case GreaterOrEqual(Number(x), Number(y)) => Boolean(x >= y)
    case expr => expr
  }

}