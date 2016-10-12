package ar.edu.unq.variable

import java.util.{Dictionary, Optional}

import ar.edu.unq.program.{Expression, Program}


case class Variable(key: String, p: Option[Expression]) extends Expression{

  val mivariable = (key,None)

  override def execute: Expression = ???

}

  object Variable{
    def apply(key: String) = Variable(key,None)

    def apply(key: String,expression: Expression ) = Variable(key, Some(expression))

  }




