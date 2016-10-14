package ar.edu.unq.program

import scala.collection.mutable

class Memory {
  def apply(key: String) = get(key)
  def apply(key: String, value: Option[Value]) = set(key, value).flatten

  val varsMap = mutable.Map[String, Option[Value]]()

  def clear() = varsMap.clear()

  def set(key: String, value: Option[Value]) = varsMap put (key, value)

  def get(key: String): Option[Value] = varsMap get key flatten

  def contains(key: String) = varsMap contains key

  override def equals(other: scala.Any): scala.Boolean = other match {
      case m: Memory => m.isInstanceOf[Memory] && m.varsMap == this.varsMap
      case _ => false
    }

}
