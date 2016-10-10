package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Division, Number}

trait CheckerDivOperationSpec extends BaseSpec {

  "Check valid Divisions" should "not return Problelms" in {
    expectNoProblemsOnDivision(4, 2)
    expectNoProblemsOnDivision(2, 3)
    expectNoProblemsOnDivision(-1, 2)
  }

  "Check Division with Number(0) at divider" should "return Error with message of invalid operation" in {
    expectDivisionByZeroError(1, 0)
    expectDivisionByZeroError(2, 0)
    expectDivisionByZeroError(0, 0)
  }

  def expectNoProblemsOnDivision(x: Int, y: Int) = {
    expectNoProblems(Division(Number(x), Number(y)))
  }

  def expectDivisionByZeroError(x: Int, y: Int) = {
    expectError(
      Division(Number(x), Number(y)),
      "Invalid operation: it is dividing by zero"
    )
  }

}
