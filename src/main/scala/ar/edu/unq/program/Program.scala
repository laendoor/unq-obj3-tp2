package ar.edu.unq.program

/**
  * Un Programa es una lista de expresiones
  *
  * @param expressions
  */
case class Program(expressions: List[Expression])


abstract class Value{}
/**
  * Expresión
  */
abstract class Expression extends Value {

  def run(expression: Expression): Expression ={

    return  new Expression{}

  }
}

/**
  * Alias Types
  */
object AliasType {
  type CheckerRule = PartialFunction[Expression, Option[Problem]]
  type RefactorRule = PartialFunction[Expression, Expression]
}

