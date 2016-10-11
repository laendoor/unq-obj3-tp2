package ar.edu.unq

import ar.edu.unq.numbers._

object MkSum {
  def apply(x: Int, y: Int) = Sum(Number(x), Number(y))
}

object MkSubtraction {
  def apply(x: Int, y: Int) = Subtraction(Number(x), Number(y))
}

object MkMultiplication {
  def apply(x: Int, y: Int) = Multiplication(Number(x), Number(y))
}

object MkDivision {
  def apply(x: Int, y: Int) = Division(Number(x), Number(y))
}

object MkEquals {
  def apply(x: Int, y: Int) = Equals(Number(x), Number(y))
}

object MkDistinct {
  def apply(x: Int, y: Int) = Distinct(Number(x), Number(y))
}

object MkLesser {
  def apply(x: Int, y: Int) = Lesser(Number(x), Number(y))
}

object MkGreater {
  def apply(x: Int, y: Int) = Greater(Number(x), Number(y))
}

object MkLesserOrEqual {
  def apply(x: Int, y: Int) = LesserOrEqual(Number(x), Number(y))
}

object MkGreaterOrEqual {
  def apply(x: Int, y: Int) = GreaterOrEqual(Number(x), Number(y))
}