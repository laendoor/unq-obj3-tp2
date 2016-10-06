package ar.edu.unq

class NumberTest extends BaseSpec {

  "Number 2" should "have value 2" in {
    val two = Number(2)

    (two match {
      case Number(v) => v
      case _ => None
    }) shouldBe 2
  }

}
