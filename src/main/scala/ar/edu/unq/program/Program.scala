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

  def run: Expression ={

    return  new Expression{}

  }
}

/**
  * Alias Types
  */
object AliasType {
  type Rule = PartialFunction[Expression, Option[Problem]]
  type RefactorRules = PartialFunction[Expression, Expression]
}

