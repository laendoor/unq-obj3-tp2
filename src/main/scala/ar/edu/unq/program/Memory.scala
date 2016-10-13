package ar.edu.unq.program

object Memory {

  val varsMap = scala.collection.mutable.Map[String, Option[Value]]()

  def set(key: String, value: Option[Value]) = varsMap put (key, value)

  def get(key: String): Option[Value] = varsMap getOrElse (key, None)
}
