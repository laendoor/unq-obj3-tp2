package ar.edu.unq.numbers

import ar.edu.unq.{program, _}
import ar.edu.unq.program.Expression

abstract class Comparison(n: program.Number, m: program.Number) extends Expression

case class Equals(n: program.Number, m: program.Number)   extends Comparison(n, m)
case class Distinct(n: program.Number, m: program.Number) extends Comparison(n, m)
case class Greater(n: program.Number, m: program.Number)  extends Comparison(n, m)
case class Lesser(n: program.Number, m: program.Number)   extends Comparison(n, m)
case class GreaterOrEqual(n: program.Number, m: program.Number) extends Comparison(n, m)
case class LesserOrEqual(n: program.Number, m: program.Number)  extends Comparison(n, m)

