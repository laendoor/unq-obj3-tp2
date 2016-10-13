package ar.edu.unq.program

import scala.collection.mutable

object Memory {

  val varsMap = mutable.Map[String, Option[Value]]()

  def clear() = varsMap.clear()

  def set(key: String, value: Option[Value]) = varsMap put (key, value)

  def get(key: String): Option[Value] = varsMap getOrElse (key, None)

  def contains(key: String) = varsMap contains key

}
