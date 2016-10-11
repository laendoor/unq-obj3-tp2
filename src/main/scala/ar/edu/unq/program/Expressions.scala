package ar.edu.unq.program

/**
  * Expresión
  */
abstract class Expression {
  def execute: Expression
}

abstract class Value extends Expression {
  override def execute: Expression = this
}

case class Number(value: Int) extends Value
case class Boolean(value: scala.Boolean) extends Value
