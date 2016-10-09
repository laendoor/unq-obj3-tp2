package ar.edu.unq.program

/**
  * Un Programa es una lista de expresiones
  *
  * @param expressions
  */
case class Program(expressions: List[Expression])

/**
  * Expresión
  */
abstract class Expression

/**
  * Alias Types
  */
object AliasType {
  type Rule = PartialFunction[Expression, Option[Problem]]
}
