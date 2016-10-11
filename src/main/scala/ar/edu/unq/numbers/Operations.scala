package ar.edu.unq.numbers

import ar.edu.unq.program.{Expression, Number}

abstract class Operation(n: Number, m: Number) extends Expression

case class Sum(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Expression = Number(n.value + m.value)
}

case class Subtraction(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Expression = Number(n.value - m.value)
}

case class Division(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Expression = Number(n.value / m.value)
}

case class Multiplication(n: Number, m: Number) extends Operation(n, m) {
  override def execute: Expression = Number(n.value * m.value)
}
