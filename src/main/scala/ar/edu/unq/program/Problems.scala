package ar.edu.unq.program

abstract class Problem(
  val severity: Severity,
  val message: String,
  val expression: Expression
)

case class InvalidExpressionProblem(override val expression: Expression)
  extends Problem(Error, "[Error] Invalid expression", expression)