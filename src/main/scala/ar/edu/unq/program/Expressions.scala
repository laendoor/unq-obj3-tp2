package ar.edu.unq.program

/**
  * Expresión
  */
abstract class Expression

abstract class Value extends Expression

case class Number(value: Int) extends Value
case class Boolean(value: scala.Boolean) extends Value
