package ar.edu.unq.checker

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{ComparisonRules, OperationRules}
import ar.edu.unq.program.AliasType.Rule
import ar.edu.unq.program._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class BaseCheckerSpec extends BaseSpec {

  val notContainProblems = "not contain problems"
  val containRedundancyWarningMessage = "contain a warning problem and redundancy message"
  val containInvalidOperationErrorMessage = "contain an error problem and invalid operation message"
  val containAlwaysTrueComparisionWarningMessage = "contain a warning problem and an always-true comparison message"
  val containAlwaysFalseComparisionWarningMessage = "contain a warning problem and an always-false comparison message"

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
      OperationRules.sumZero,
      OperationRules.subZero,
      OperationRules.divideByOne,
      OperationRules.divideByZero,
      OperationRules.multiplyByOne,
      OperationRules.multiplyByZero,
      ComparisonRules.equality,
      ComparisonRules.inequality,
      ComparisonRules.lesser,
      ComparisonRules.greater,
      ComparisonRules.lesserOrEqual,
      ComparisonRules.greaterOrEqual
    )
  }
}
