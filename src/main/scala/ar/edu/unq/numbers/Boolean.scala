package ar.edu.unq.numbers

import ar.edu.unq.program.Expression


abstract class Boolean extends Expression{}

case class TRUE() extends Boolean{}
case class FALSE() extends Boolean{}

