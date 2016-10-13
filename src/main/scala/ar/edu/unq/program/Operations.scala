package ar.edu.unq.program

abstract class Operation(n: Number, m: Number) extends Expression

case class Sum(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Value = Number(n.value + m.value)
}

case class Subtraction(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Value = Number(n.value - m.value)
}

case class Division(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Value = Number(n.value / m.value)
}

case class Multiplication(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Value = Number(n.value * m.value)
}
