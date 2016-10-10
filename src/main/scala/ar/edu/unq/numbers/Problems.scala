package ar.edu.unq.numbers

import ar.edu.unq.program.{Expression, Problem, Warning}

case class AddZeroProblem(override val expression: Expression)
  extends Problem(Warning,
    "[Warning] Redundant operation: it is adding zero",
    expression)

case class MultByOneProblem(override val expression: Expression) extends Problem(Warning,
    "[Warning] you are multiplying by one ", expression )
