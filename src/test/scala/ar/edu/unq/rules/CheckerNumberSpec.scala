package ar.edu.unq.rules

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.Number

trait CheckerNumberSpec extends BaseSpec {

  "Check Numbers" should notContainProblems in {
    expectNoProblems(Number(-2))
    expectNoProblems(Number(-1))
    expectNoProblems(Number(0))
    expectNoProblems(Number(1))
    expectNoProblems(Number(2))
  }

}
