package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object SumRules {
  val addZero: Rule = {
    case s @ Sum(Number(_), Number(0)) => Some(AddZeroProblem(s))
    case _ => None
  }
}

// FIXME
object DivisionRules {
  val divideByZero: Rule = {
    case _ => None
  }
}