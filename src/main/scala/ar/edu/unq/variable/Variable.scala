package ar.edu.unq.variable

import ar.edu.unq.program.{Expression, Value}


case class Variable(key: String, p: Option[Expression]) extends Expression{

  val mivariable = (key,None)

  override def execute: Value = ???
}

  object Variable {
//    def apply(key: String) = Variable(key,None)
//
//    def apply(key: String, expression: Expression ) = Variable(key, Some(expression))
//
  }




