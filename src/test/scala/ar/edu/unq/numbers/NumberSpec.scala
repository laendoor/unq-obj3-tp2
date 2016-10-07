package ar.edu.unq.numbers

import ar.edu.unq.{BaseSpec, Check, Program}

class NumberSpec extends BaseSpec {

  "Number 2" should "have value 2" in {
    val two = Number(2)

    two.value shouldBe 2
  }

  "Checker over Number(2)" should "return Number(2)" in {
    val number = Program(Number(2))

    Check(number).get shouldBe number
  }

  "Checker over Sum(Number(2), Number(3))" should "return None" in {
    val sum = Program(Sum(Number(2), Number(3)))

    Check(sum) shouldBe None
  }

}
