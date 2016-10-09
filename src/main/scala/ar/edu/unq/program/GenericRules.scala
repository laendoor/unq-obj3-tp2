package ar.edu.unq.program

import ar.edu.unq.numbers.{Number, Operation}
import ar.edu.unq.program.AliasType.Rule

object GenericRules {
  val validExpression: Rule = {
    case  n: Number    => None
    case op: Operation => None
    // FIXME add rest
    case e => Some(InvalidExpressionProblem(e))
  }
}
