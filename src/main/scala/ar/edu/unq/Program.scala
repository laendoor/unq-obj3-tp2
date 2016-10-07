package ar.edu.unq

import ar.edu.unq.numbers.Number

case class Program(e: Expression)

abstract class Expression

object Check {
  def apply(program: Program): Option[Program] = {
    program.e match {
      case n: Number => Some(Program(n))
      case _ => None
    }
  }
}