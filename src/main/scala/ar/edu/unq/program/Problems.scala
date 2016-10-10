package ar.edu.unq.program

abstract class Problem(
  val severity: Severity,
  val message: String,
  val expression: Expression
)

abstract class WarningProblem(description: String, expression: Expression)
  extends Problem(Warning, s"[Warning] $description", expression)

abstract class ErrorProblem(description: String, expression: Expression)
  extends Problem(Error, s"[Error] $description", expression)
