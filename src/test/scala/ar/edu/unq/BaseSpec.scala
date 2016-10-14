package ar.edu.unq

import ar.edu.unq.program.AliasType._
import ar.edu.unq.program.{Checker, Program, Refactor}
import ar.edu.unq.rules._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

/**
  *
  */
abstract class BaseSpec extends FlatSpec
  with Matchers
  with BeforeAndAfter

/**
  *
  */
object CheckAllRules {
  def apply(program: Program) = Checker(program, allRules, allGlobalRules)

  def allRules: List[CheckerRule] = {
    List(
      CheckerOperationRules.smart,
      CheckerComparisonRules.smart
    )
  }

  def allGlobalRules: List[CheckerGlobalRule] = List(
    CheckerVarRules.definitions,
    CheckerVarRules.uses
  )
}

/**
  *
  */
object RefactorWithAllRules {
  def apply(program: Program) = Refactor(program, allRules)

  def allRules: List[RefactorRule] = {
    List(
      RefactorOperationRules.smart,
      RefactorComparisonRules.smart
    )
  }
}