package ar.edu.unq.vars

import ar.edu.unq.program.{Expression, Memory, Null, Value}

class Var(val key: String, val value: Option[Value]) extends Expression {
  override def executeIn(memory: Memory): Value = {
    memory set (key, value)
    value.getOrElse(Null)
  }
}

object Var {
  def apply(key: String) = new Var(key, None)
  def apply(key: String, value: Value) = new Var(key, Some(value))

  def unapply(v: Var): Option[(String, Option[Value])] = Some(v.key, v.value)
}

case class Ref(key: String) extends Value {
  override def executeIn(memory: Memory): Value = memory get key getOrElse Null
}

case class Assign(ref: Ref, value: Value) extends Expression {
  override def executeIn(memory: Memory): Value = {
    memory set (ref.key, Some(value))
    value
  }
}
