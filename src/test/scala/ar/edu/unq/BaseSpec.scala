package ar.edu.unq

import ar.edu.unq.numbers.OperationRules
import ar.edu.unq.program.AliasType.Rule
import ar.edu.unq.program.{Checker, GenericRules, Program}
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class BaseSpec extends FlatSpec
  with Matchers
  with BeforeAndAfter

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
      OperationRules.multiplyByOne
    )
  }
}