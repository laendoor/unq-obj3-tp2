package ar.edu.unq

class Number(val value: Int)

object Number {
  def apply(value: Int): Number = new Number(value)
  def unapply(number: Number) : Option[Int] = Some(number.value)
}
