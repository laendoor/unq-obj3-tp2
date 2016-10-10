package ar.edu.unq.numbers

import ar.edu.unq.program.AliasType._

object OperationRules {
  val sumZero: Rule = {
    case s @ Sum(Number(x), Number(y))
      if x == 0 || y == 0 => Some(SumZeroProblem(s))
    case _ => None
  }

  val subZero: Rule = {
    case s @Sub(_, Number(0)) => Some(SubZeroProblem(s))
    case _ => None
  }

  val divideByZero: Rule = {
    case d @ Division(_,Number(0)) => Some(DivideByZeroProblem(d))
    case _ => None
  }

  val multiplyByOne: Rule = {
    case m @ Multiplication(_, Number(1)) => Some(MultiplyByOneProblem(m))
    case m @ Multiplication(Number(1), _) => Some(MultiplyByOneProblem(m))
    case _ => None
  }

  val multiplyByZero: Rule = {
    case m @ Multiplication(_, Number(0)) => Some(MultiplyByZeroProblem(m))
    case m @ Multiplication(Number(0), _) => Some(MultiplyByZeroProblem(m))
    case _ => None
  }
}

