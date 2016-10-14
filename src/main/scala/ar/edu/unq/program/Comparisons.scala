package ar.edu.unq.program

abstract class Comparison(val x: Value, val y: Value)  extends Expression {

  def exec(m: Memory, x: Value, y: Value, op: (Int, Int) => scala.Boolean): Option[Value] = {
    val xVal = numberOf(x executeIn m).value
    val yVal = numberOf(y executeIn m).value
    Some apply Boolean(op(xVal, yVal))
  }

}

case class Equals(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ == _)
}

case class Distinct(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ != _)
}

case class Greater(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ > _)
}

case class Lesser(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ < _)
}

case class GreaterOrEqual(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ >= _)
}

case class LesserOrEqual(x0: Value, y0: Value) extends Comparison(x0, y0) {
  override def executeIn(m: Memory) = exec(m, x, y, _ <= _)
}

