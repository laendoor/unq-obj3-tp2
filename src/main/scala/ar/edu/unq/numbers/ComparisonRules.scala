package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object ComparisonRules {
  val equality: Rule = {
    case e @ Equals(Number(x), Number(y)) if x == y => Some(TrueComparisonProblem(e))
    case e @ Equals(Number(x), Number(y)) if x != y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val inequality: Rule = {
    case e @ Distinct(Number(x), Number(y)) if x == y => Some(FalseComparisonProblem(e))
    case e @ Distinct(Number(x), Number(y)) if x != y => Some(TrueComparisonProblem(e))
    case _ => None
  }

  val lesser: Rule = {
    case e @ Lesser(Number(x), Number(y)) if x < y  => Some(TrueComparisonProblem(e))
    case e @ Lesser(Number(x), Number(y)) if x >= y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val greater: Rule = {
    case e @ Greater(Number(x), Number(y)) if x > y  => Some(TrueComparisonProblem(e))
    case e @ Greater(Number(x), Number(y)) if x <= y => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val lesserOrEqual: Rule = {
    case e @ LesserOrEqual(Number(x), Number(y)) if x <= y => Some(TrueComparisonProblem(e))
    case e @ LesserOrEqual(Number(x), Number(y)) if x > y  => Some(FalseComparisonProblem(e))
    case _ => None
  }

  val greaterOrEqual: Rule = {
    case e @ GreaterOrEqual(Number(x), Number(y)) if x >= y => Some(TrueComparisonProblem(e))
    case e @ GreaterOrEqual(Number(x), Number(y)) if x < y  => Some(FalseComparisonProblem(e))
    case _ => None
  }
}
