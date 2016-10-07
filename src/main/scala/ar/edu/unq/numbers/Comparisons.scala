package ar.edu.unq.numbers

import ar.edu.unq.Expression

abstract class Comparision(n: Number, m: Number) extends Expression

case class Equals(n: Number, m: Number) extends Comparision(n, m)

case class Distinct(n: Number, m: Number) extends Comparision(n, m)

case class Greater(n: Number, m: Number) extends Comparision(n, m)

case class Lesser(n: Number, m: Number) extends Comparision(n, m)

case class GreaterOrEqual(n: Number, m: Number) extends Comparision(n, m)

case class LesserOrEqual(n: Number, m: Number) extends Comparision(n, m)

