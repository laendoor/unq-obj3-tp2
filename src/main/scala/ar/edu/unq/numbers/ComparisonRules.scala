package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object ComparisonRules {
  val equality: Rule = {
    case e @ Equals(Number(x), Number(y)) if x == y => Some(TrueEqualityProblem(e))
    case e @ Equals(Number(x), Number(y)) if x != y => Some(FalseEqualityProblem(e))
    case _ => None
  }
}
