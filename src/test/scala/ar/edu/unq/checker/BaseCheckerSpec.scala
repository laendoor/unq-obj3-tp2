package ar.edu.unq.checker

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{ComparisonRules, OperationRules}
import ar.edu.unq.program.AliasType.CheckerRule
import ar.edu.unq.program._

class BaseCheckerSpec extends BaseSpec {

  val notContainProblems = "not contain problems"
  val containRedundancyWarningMessage = "contain a warning problem and redundancy message"
  val containInvalidOperationErrorMessage = "contain an error problem and invalid operation message"
  val containAlwaysTrueComparisionWarningMessage = "contain a warning problem and an always-true comparison message"
  val containAlwaysFalseComparisionWarningMessage = "contain a warning problem and an always-false comparison message"

}

object CheckAllRules {
  def apply(program: Program) = Checker(program, allRules)

  def allRules: List[CheckerRule] = {
    List(
      OperationRules.smart,
      ComparisonRules.smart
    )
  }
}

