package ar.edu.unq.numbers

import ar.edu.unq.program.{Expression, WarningProblem}


// FIXME
case class TrueEqualityProblem(override val expression: Expression)
  extends WarningProblem("Redundant operation: this comparison always gives True", expression)

case class ComparisonProblemFalse(override val expression: Expression)
  extends WarningProblem("Redundant operation: this comparison always gives False", expression)
