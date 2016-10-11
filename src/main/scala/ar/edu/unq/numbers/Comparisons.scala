package ar.edu.unq.numbers

import ar.edu.unq.program
import ar.edu.unq.program.{Expression, Boolean}

abstract class Comparison(n: program.Number, m: program.Number) extends Expression

case class Equals(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value == m.value)
}

case class Distinct(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value != m.value)
}

case class Greater(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value > m.value)
}

case class Lesser(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value < m.value)
}

case class GreaterOrEqual(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value >= m.value)
}

case class LesserOrEqual(n: program.Number, m: program.Number) extends Comparison(n, m) {
  override def execute: Expression = Boolean(n.value <= m.value)
}

