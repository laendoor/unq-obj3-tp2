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

  def expectWarning(expr: Expression, message: String) = {
    val program = Program(expr :: Nil)
    val problems = CheckAllRules(program)

    problems.size shouldBe 1
    val problem = problems.head

    problem.severity   shouldBe Warning
    problem.message    should startWith ("[Warning]")
    problem.message    should include (message)
    problem.expression shouldBe expr
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

