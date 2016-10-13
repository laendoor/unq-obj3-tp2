package ar.edu.unq.vars

import ar.edu.unq.program.{Expression, Memory, Null, Value}

class Var(key: String, value: Option[Value]) extends Expression {
  override def execute: Value = {
    Memory set (key, value)
    value.getOrElse(Null)
  }
}

object Var {
  def apply(key: String) = new Var(key, None)
  def apply(key: String, value: Value) = new Var(key, Some(value))
}

case class Ref(key: String) extends Value {
  override def execute: Value = Memory.get(key).getOrElse(Null)
}

case class Assign(ref: Ref, value: Value) extends Expression {
  override def execute: Value = {
    Memory set (ref.key, Option(value))
    value
  }
}
