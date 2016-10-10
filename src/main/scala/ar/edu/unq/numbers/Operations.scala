package ar.edu.unq.numbers

import ar.edu.unq.program.Expression

abstract class Operation(n: Number, m: Number) extends Expression

case class Sum(n: Number, m: Number)            extends Operation(n, m)
case class Subtraction(n: Number, m: Number)    extends Operation(n, m)
case class Division(n: Number, m: Number)       extends Operation(n, m)
case class Multiplication(n: Number, m: Number) extends Operation(n, m)
