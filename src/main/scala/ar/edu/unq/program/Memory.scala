package ar.edu.unq.program

import scala.collection.mutable

class Memory {

  val varsMap = mutable.Map[String, Option[Value]]()

  def clear() = varsMap.clear()

  def set(key: String, value: Option[Value]) = varsMap put (key, value)

  def get(key: String): Option[Value] = varsMap getOrElse (key, None)

  def contains(key: String) = varsMap contains key

  override def equals(other: scala.Any): scala.Boolean = other match {
      case m: Memory => m.isInstanceOf[Memory] && m.varsMap == this.varsMap
      case _ => false
    }

}
