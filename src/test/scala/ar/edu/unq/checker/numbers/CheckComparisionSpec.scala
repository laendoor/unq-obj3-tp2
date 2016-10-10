package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers._

trait CheckComparisionSpec extends BaseSpec {

  "Check Equals" should s"$containAlwaysTrueComparisionWarningMessage if numbers are equals" in {
    expectAlwaysTrueWarning(MkEquals(0, 0))
    expectAlwaysTrueWarning(MkEquals(1, 1))
    expectAlwaysTrueWarning(MkEquals(2, 2))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if numbers are different" in {
    expectAlwaysFalseWarning(MkEquals(0, 1))
    expectAlwaysFalseWarning(MkEquals(1, 2))
    expectAlwaysFalseWarning(MkEquals(2, 3))
    expectAlwaysFalseWarning(MkEquals(3, 2))
    expectAlwaysFalseWarning(MkEquals(2, 1))
    expectAlwaysFalseWarning(MkEquals(1, 0))
  }

  "Check Distinct" should s"$containAlwaysTrueComparisionWarningMessage if numbers are different" in {
    expectAlwaysTrueWarning(MkDistinct(0, 1))
    expectAlwaysTrueWarning(MkDistinct(1, 2))
    expectAlwaysTrueWarning(MkDistinct(2, 3))
    expectAlwaysTrueWarning(MkDistinct(3, 2))
    expectAlwaysTrueWarning(MkDistinct(2, 1))
    expectAlwaysTrueWarning(MkDistinct(1, 0))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if numbers are equals" in {
    expectAlwaysFalseWarning(MkDistinct(0, 0))
    expectAlwaysFalseWarning(MkDistinct(1, 1))
    expectAlwaysFalseWarning(MkDistinct(2, 2))
  }

  "Check Lesser" should s"$containAlwaysTrueComparisionWarningMessage if first number is lesser than second" in {
    expectAlwaysTrueWarning(MkLesser(0, 1))
    expectAlwaysTrueWarning(MkLesser(1, 2))
    expectAlwaysTrueWarning(MkLesser(2, 3))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if first number is greater-or-equals than second" in {
    expectAlwaysFalseWarning(MkLesser(0, 0))
    expectAlwaysFalseWarning(MkLesser(1, 0))
    expectAlwaysFalseWarning(MkLesser(1, 1))
    expectAlwaysFalseWarning(MkLesser(2, 1))
  }

  "Check Greater" should s"$containAlwaysTrueComparisionWarningMessage if first number is greater than second" in {
    expectAlwaysTrueWarning(MkGreater(1, 0))
    expectAlwaysTrueWarning(MkGreater(2, 1))
    expectAlwaysTrueWarning(MkGreater(3, 2))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if first number is lesser-or-equals than second" in {
    expectAlwaysFalseWarning(MkGreater(0, 0))
    expectAlwaysFalseWarning(MkGreater(0, 1))
    expectAlwaysFalseWarning(MkGreater(1, 1))
    expectAlwaysFalseWarning(MkGreater(1, 2))
  }

  "Check LesserOrEquals" should s"$containAlwaysTrueComparisionWarningMessage if first number is lesser-or-equal than second" in {
    expectAlwaysTrueWarning(MkLesserOrEqual(0, 0))
    expectAlwaysTrueWarning(MkLesserOrEqual(0, 1))
    expectAlwaysTrueWarning(MkLesserOrEqual(1, 1))
    expectAlwaysTrueWarning(MkLesserOrEqual(1, 2))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if first number is greater than second" in {
    expectAlwaysFalseWarning(MkLesserOrEqual(1, 0))
    expectAlwaysFalseWarning(MkLesserOrEqual(2, 1))
    expectAlwaysFalseWarning(MkLesserOrEqual(3, 2))
  }

  "Check GreaterOrEquals" should s"$containAlwaysTrueComparisionWarningMessage if first number is greater-or-equal than second" in {
    expectAlwaysTrueWarning(MkGreaterOrEqual(0, 0))
    expectAlwaysTrueWarning(MkGreaterOrEqual(1, 0))
    expectAlwaysTrueWarning(MkGreaterOrEqual(1, 1))
    expectAlwaysTrueWarning(MkGreaterOrEqual(2, 1))
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if first number is lesser than second" in {
    expectAlwaysFalseWarning(MkGreaterOrEqual(0, 1))
    expectAlwaysFalseWarning(MkGreaterOrEqual(1, 2))
    expectAlwaysFalseWarning(MkGreaterOrEqual(2, 3))
  }

  def expectAlwaysTrueWarning(cmp: Comparison)  = expectNonSenseWarning(cmp, "True")
  def expectAlwaysFalseWarning(cmp: Comparison) = expectNonSenseWarning(cmp, "False")
  def expectNonSenseWarning(cmp: Comparison, value: String) = {
    expectWarning(cmp, s"Non-Sense Comparison: this comparison always gives $value")
  }

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