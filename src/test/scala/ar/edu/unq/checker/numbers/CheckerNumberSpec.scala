package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.checker.numbers.operations.{CheckerDivOperationSpec, CheckerMulOperationSpec, CheckerSubOperationSpec, CheckerSumOperationSpec}
import ar.edu.unq.numbers.Number

trait CheckerNumberSpec extends BaseSpec
  with CheckerSumOperationSpec
  with CheckerSubOperationSpec
  with CheckerMulOperationSpec
  with CheckerDivOperationSpec {

  "Check Numbers" should notContainProblems in {
    expectNoProblems(Number(-2))
    expectNoProblems(Number(-1))
    expectNoProblems(Number(0))
    expectNoProblems(Number(1))
    expectNoProblems(Number(2))
  }

}
