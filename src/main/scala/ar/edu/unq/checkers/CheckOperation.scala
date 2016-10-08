package ar.edu.unq.checkers

import ar.edu.unq.{Problem, Warning, Error}
import ar.edu.unq.numbers._

object CheckOperation {
  def apply(op: Operation): Option[Problem] = {
    op match {
      case sum: Sum => CheckerSumOperation(sum)
      case sub: Sub => CheckerSubOperation(sub)
      case div: Division => CheckerDivOperation(div)
      case mul: Multiplication => CheckerMulOperation(mul)
      case op => Some(Problem(Error, "[Error] Invalid operation", op))
    }
  }
}

object CheckerSumOperation {
  def apply(sum: Sum): Option[Problem] = {
    sum match {
      case s @ Sum(Number(_), Number(0)) => Some(Problem(Warning, "[Warning] Redundant operation: it is adding zero", s))
      case _ => None
    }
  }
}

object CheckerSubOperation {
  def apply(sub: Sub): Option[Problem] = {
    sub match {
      case _ => None
    }
  }
}


object CheckerDivOperation {
  def apply(div: Division): Option[Problem] = {
    div match {
      case _ => None
    }
  }
}


object CheckerMulOperation {
  def apply(mul: Multiplication): Option[Problem] = {
    mul match {
      case _ => None
    }
  }
}
