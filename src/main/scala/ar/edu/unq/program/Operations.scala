package ar.edu.unq.program

abstract class Operation(val x: Value, val y: Value) extends Expression {

  def exec(m: Memory, x: Value, y: Value, op: (Int, Int) => Int): Option[Value] = {
    val xVal = numberOf(x executeIn m).value
    val yVal = numberOf(y executeIn m).value
    Some apply Number(op(xVal, yVal))
  }

}

case class Sum(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ + _)
}

case class Subtraction(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ - _)
}

case class Division(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ / _)
}

case class Multiplication(x0: Value, y0: Value) extends Operation(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ * _)
}
