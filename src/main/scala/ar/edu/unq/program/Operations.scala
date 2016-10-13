package ar.edu.unq.program

abstract class Operation(val x: Value, val y: Value) extends Expression {
  def valueOf(v: Value): Int = v match {
    case v: Number => v.value
    case _ => 0
  }
}

case class Sum(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory): Value = Number(valueOf(x executeIn m) + valueOf(y executeIn m))
}

case class Subtraction(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory): Value = Number(valueOf(x executeIn m)  - valueOf(y executeIn m))
}

case class Division(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory): Value = Number(valueOf(x executeIn m)  / valueOf(y executeIn m))
}

case class Multiplication(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory): Value = Number(valueOf(x executeIn m)  * valueOf(y executeIn m))
}
