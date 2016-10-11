package ar.edu.unq.program

/**
  * Un Programa es una lista de expresiones
  *
  * @param expressions
  */
case class Program(expressions: List[Expression])


/**
  * Alias Types
  */
object AliasType {
  type CheckerRule  = PartialFunction[Expression, Option[Problem]]
  type RefactorRule = PartialFunction[Expression, Expression]
}

