package ar.edu.unq.numbers

import ar.edu.unq.program.{Expression, Problem, Warning}

case class AddZeroProblem(override val expression: Expression)
  extends Problem(Warning,
    "[Warning] Redundant operation: it is adding zero",
    expression)

case class MultByOneProblem(override val expression: Expression) extends Problem(Warning,
    "[Warning] Redundant operation:  you are multiplying by one ", expression )

case class SubByZeroProblem(override val expression: Expression) extends Problem(Warning,
    "[Warning] Redundant operation:  you are sub by zero ", expression )

case class ComparisionProblemTrue(override val expression: Expression)extends Problem(Warning,
    "[Warning] Redundant operation: this comparison always gives True", expression )

case class ComparisionProblemFalse(override val expression: Expression)extends Problem(Warning,
    "[Warning] Redundant operation: this comparison always gives False", expression )
