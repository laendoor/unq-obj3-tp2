package ar.edu.unq.program

/**
  * Un Programa es una lista de expresiones
  */
case class Program(expressions: List[Expression]) {
//  override def equals(other: scala.Any): scala.Boolean =
//    other match {
//      case p: Program => p.isInstanceOf[Program] && p.expressions == this.expressions
//      case _ => false
//    }
}

/**
  * Alias Types
  */
object AliasType {
  type CheckerRule  = PartialFunction[Expression, Option[Problem]]
  type RefactorRule = PartialFunction[Expression, Expression]
  type CheckerGlobalRule = PartialFunction[(Expression, List[Expression]), Option[Problem]]
}

