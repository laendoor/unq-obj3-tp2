package ar.edu.unq.refactor

import ar.edu.unq.BaseSpec
import ar.edu.unq.program.AliasType.RefactorRule
import ar.edu.unq.program._
import ar.edu.unq.rules.{RefactorComparisonRules, RefactorOperationRules}

class BaseRefactorSpec extends BaseSpec

object RefactorWithAllRules {
  def apply(program: Program) = Refactor(program, allRules)

  def allRules: List[RefactorRule] = {
    List(
      RefactorOperationRules.smart,
      RefactorComparisonRules.smart
    )
  }
}

