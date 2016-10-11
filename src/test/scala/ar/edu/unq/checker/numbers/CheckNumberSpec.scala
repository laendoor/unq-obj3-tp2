package ar.edu.unq.checker.numbers

import ar.edu.unq.checker.BaseCheckerSpec
import ar.edu.unq.numbers.Number

trait CheckNumberSpec extends BaseCheckerSpec {

  "Check Numbers" should notContainProblems in {
    expectNoProblems(Number(-2))
    expectNoProblems(Number(-1))
    expectNoProblems(Number(0))
    expectNoProblems(Number(1))
    expectNoProblems(Number(2))
  }

}
