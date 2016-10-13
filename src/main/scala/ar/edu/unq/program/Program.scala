package ar.edu.unq.program

/**
  * Un Programa es una lista de expresiones
  */
class Program(val expressions: List[Expression], val memory: Memory) {
  override def equals(other: scala.Any): scala.Boolean = other match {
      case p: Program => p.isInstanceOf[Program] && p.expressions == this.expressions && p.memory == this.memory
      case _ => false
    }
}

/**
  * Alias Types
  */
object AliasType {
  type CheckerRule  = PartialFunction[Expression, Option[Problem]]
  type RefactorRule = PartialFunction[Expression, Expression]
  type CheckerGlobalRule = PartialFunction[(Expression, List[Expression]), Option[Problem]]
}

