package ar.edu.unq.numbers

import ar.edu.unq.program.{Expression, Problem, Warning, Error}

case class SumZeroProblem(override val expression: Expression)
  extends Problem(Warning,
    "[Warning] Redundant operation: it is adding zero", expression)

case class SubZeroProblem(override val expression: Expression) extends Problem(Warning,
    "[Warning] Redundant operation: it is subtracting zero", expression)

case class DivideByZeroProblem(override val expression: Expression) extends Problem(Error,
    "[Error] Invalid operation: it is dividing by zero", expression)

case class MultiplyByOneProblem(override val expression: Expression) extends Problem(Warning,
    "[Warning] Redundant operation: it is multiplying by one", expression)

