package ar.edu.unq.numbers

import ar.edu.unq.{program, _}
import ar.edu.unq.program.Expression

abstract class Operation(n: program.Number, m: program.Number) extends Expression

case class Sum(n: program.Number, m: program.Number)            extends Operation(n, m)
case class Subtraction(n: program.Number, m: program.Number)    extends Operation(n, m)
case class Division(n: program.Number, m: program.Number)       extends Operation(n, m)
case class Multiplication(n: program.Number, m: program.Number) extends Operation(n, m)
