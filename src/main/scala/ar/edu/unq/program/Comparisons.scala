package ar.edu.unq.program

abstract class Comparison(val a: Number, val b: Number) extends Expression {

  def exec(m: Memory, a: Number, b: Number, op: (Int, Int) => scala.Boolean): Option[Value] = {
    val a0 = numberOf(a executeIn m).value
    val b0 = numberOf(b executeIn m).value
    Some apply Boolean(op(a0, b0))
  }

}

case class Equals(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ == _)
}

case class Distinct(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ != _)
}

case class Greater(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ > _)
}

case class Lesser(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ < _)
}

case class GreaterOrEqual(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ >= _)
}

case class LesserOrEqual(x: Number, y: Number) extends Comparison(x, y) {
  override def executeIn(m: Memory) = exec(m, x, y, _ <= _)
}

