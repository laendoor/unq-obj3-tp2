package ar.edu.unq.vars

import ar.edu.unq.program.{Expression, Memory, Value}

class Var(val key: String, val value: Option[Value]) extends Expression {
  override def executeIn(memory: Memory): Option[Value] = {
    memory set (key, value)
    value orElse None
  }
}

object Var {
  def apply(key: String) = new Var(key, None)
  def apply(key: String, value: Value) = new Var(key, Some(value))

  def unapply(v: Var): Option[(String, Option[Value])] = Some(v.key, v.value)
}

case class Ref(key: String) extends Value {
  override def executeIn(memory: Memory): Option[Value] = memory(key) orElse None
}

case class Assign(ref: Ref, value: Expression) extends Expression {
  override def executeIn(memory: Memory): Option[Value] = {
    memory(ref.key, value executeIn memory)
  }
}
