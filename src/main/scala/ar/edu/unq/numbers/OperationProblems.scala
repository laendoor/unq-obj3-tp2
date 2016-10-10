package ar.edu.unq.numbers

import ar.edu.unq.program.{ErrorProblem, WarningProblem}

abstract class RedundantOperationProblem(description: String, op: Operation)
  extends WarningProblem(s"Redundant operation: $description", op)

abstract class InvalidOperationProblem(description: String, op: Operation)
  extends ErrorProblem(s"Invalid operation: $description", op)

case class SumZeroProblem(sum: Sum) extends RedundantOperationProblem("it is adding zero", sum)
case class SubZeroProblem(sub: Subtraction) extends RedundantOperationProblem("it is subtracting zero", sub)

case class DivideByOneProblem(div: Division)  extends RedundantOperationProblem("it is dividing by one", div)
case class DivideByZeroProblem(div: Division) extends InvalidOperationProblem("it is dividing by zero", div)

case class MultiplyByOneProblem(mul: Multiplication)  extends RedundantOperationProblem("it is multiplying by one", mul)
case class MultiplyByZeroProblem(mul: Multiplication) extends RedundantOperationProblem("it is multiplying by zero", mul)
