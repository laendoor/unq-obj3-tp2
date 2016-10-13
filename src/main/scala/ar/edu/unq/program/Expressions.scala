package ar.edu.unq.program

/**
  * Expresión: Todo es una expresión. Las Expresiones pueden ser Valores u Operaciones.
  */
abstract class Expression {
  def execute: Value
}

abstract class Value extends Expression {
  override def execute: Value = this
}

case object Null extends Value
case class Number(value: Int) extends Value
case class Boolean(value: scala.Boolean) extends Value
