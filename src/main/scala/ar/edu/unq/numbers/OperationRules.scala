package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object SumRules {
  val addZero: Rule = {
    case s @ Sum(_, Number(0)) => Some(AddZeroProblem(s))
    case s @ Sum(Number(0), _) => Some(AddZeroProblem(s))
    case _ => None
  }
}

// FIXME
object DivisionRules {
  val divideByZero: Rule = {
    case d @ Division(_,Number(0)) => Some(AddZeroProblem(d))
    case _ => None
  }
}