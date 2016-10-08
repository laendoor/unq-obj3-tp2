package ar.edu.unq

import ar.edu.unq.checkers.CheckOperation
import ar.edu.unq.numbers.{Number, Operation}

case class Program(expressions: List[Expression])

abstract class Expression

object Checker {
  def apply(program: Program): List[Problem] = {
    checkRules(program.expressions)
  }

  def checkRules(expressions: List[Expression]): List[Problem] = expressions match {
    case Nil => Nil
    case e :: es => applyRule(e) match {
      case None => checkRules(es)
      case Some(p) => p :: checkRules(es)
    }
  }

  def applyRule(expression: Expression): Option[Problem] = expression match {
    case  n: Number    => None
    case op: Operation => CheckOperation(op)
    case e => Some(Problem(Error, "[Error] Invalid expression", e))
  }
}

case class Problem(severity: Severity, message: String, expression: Expression)

abstract class Severity

case object Error extends Severity
case object Warning extends Severity
