package ar.edu.unq.program

/**
  * Expresión: Todo es una expresión. Las Expresiones pueden ser Valores u Operaciones.
  */
abstract class Expression {
  def executeIn(memory: Memory): Option[Value]

  def numberOf(v: Option[Value]): Number = v match {
    case Some(v: Number) => v
    case _ => Number(0)
  }
}

abstract class Value extends Expression {
  override def executeIn(memory: Memory): Option[Value] = Some(this)
}

case class Number(value: Int) extends Value
case class Boolean(value: scala.Boolean) extends Value
