package ar.edu.unq

import ar.edu.unq.numbers.OperationRules
import ar.edu.unq.program.AliasType.Rule
import ar.edu.unq.program._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class BaseSpec extends FlatSpec
  with Matchers
  with BeforeAndAfter {

  def expectNoProblems(expr: Expression) = {
    val program = Program(expr :: Nil)
    CheckAllRules(program) shouldBe Nil
  }

  def expectError(expr: Expression, message: String) = expectProblem(Error, expr, message)
  def expectWarning(expr: Expression, message: String) = expectProblem(Warning, expr, message)

  def expectProblem(severity: Severity, expr: Expression, message: String) = {
    val program = Program(expr :: Nil)
    val problems = CheckAllRules(program)

    problems.map(p => p.severity)   should contain (severity)
    problems.map(p => p.message)    should contain (s"[$severity] " + message)
    problems.map(p => p.expression) should contain (expr)
  }

}

object CheckAllRules {
  def apply(program: Program) = Checker(program, AllRules())
}

object AllRules {
  def apply(): List[Rule] = {
    List(
      GenericRules.validExpression,
      OperationRules.sumZero,
      OperationRules.subZero,
      OperationRules.divideByZero,
      OperationRules.multiplyByOne,
      OperationRules.multiplyByZero
    )
  }
}

