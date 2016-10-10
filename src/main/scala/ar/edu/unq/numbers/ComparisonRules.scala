package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object ComparisonRules {
  val equality: Rule = {
    case e @Equals(Number(n), Number(m))
      if n == m => Some(TrueEqualityProblem(e))
    case _ => None
  }
}
