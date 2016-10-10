package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.checker.numbers.operations.{CheckDivisionSpec, CheckMultiplicationSpec, CheckSubtractionSpec, CheckSumSpec}
import ar.edu.unq.numbers.Number

trait CheckNumberSpec extends BaseSpec
  with CheckSumSpec
  with CheckSubtractionSpec
  with CheckMultiplicationSpec
  with CheckDivisionSpec {

  "Check Numbers" should notContainProblems in {
    expectNoProblems(Number(-2))
    expectNoProblems(Number(-1))
    expectNoProblems(Number(0))
    expectNoProblems(Number(1))
    expectNoProblems(Number(2))
  }

}
