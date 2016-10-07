package ar.edu.unq.numbers

import ar.edu.unq.Block

abstract class Operation(n: Number, m: Number) extends Block

case class Sum(n: Number, m: Number) extends Operation(n, m)

case class Sub(n: Number, m: Number) extends Operation(n, m)

case class Divison(n: Number, m: Number)  extends Operation(n, m)

case class Multiplication(n: Number, m: Number) extends Operation(n, m)
