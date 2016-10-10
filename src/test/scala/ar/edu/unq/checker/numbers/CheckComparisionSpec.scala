package ar.edu.unq.checker.numbers

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Comparison, Equals, Number}

trait CheckComparisionSpec extends BaseSpec {

  "Check Equality" should s"$containAlwaysTrueComparisionWarningMessage if numbers are equals" in {
    expectAlwaysTrueEqualityWarning(0, 0)
    expectAlwaysTrueEqualityWarning(1, 1)
    expectAlwaysTrueEqualityWarning(2, 2)
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if numbers are different" in {
    expectAlwaysFalseEqualityWarning(0, 1)
    expectAlwaysFalseEqualityWarning(1, 2)
    expectAlwaysFalseEqualityWarning(2, 3)
    expectAlwaysFalseEqualityWarning(3, 2)
    expectAlwaysFalseEqualityWarning(2, 1)
    expectAlwaysFalseEqualityWarning(1, 0)
  }

  def expectAlwaysTrueEqualityWarning(x: Int, y: Int)  = {
    expectAlwaysTrueComparisonWarning(Equals(Number(x), Number(y)))
  }

  def expectAlwaysFalseEqualityWarning(x: Int, y: Int) = {
    expectAlwaysFalseComparisonWarning(Equals(Number(x), Number(y)))
  }

  def expectAlwaysTrueComparisonWarning(cmp: Comparison)  = expectNonSenseEqualityWarning(cmp, "True")
  def expectAlwaysFalseComparisonWarning(cmp: Comparison) = expectNonSenseEqualityWarning(cmp, "False")
  def expectNonSenseEqualityWarning(cmp: Comparison, value: String) = {
    expectWarning(cmp, s"Non-Sense Comparison: this comparison always gives $value")
  }

}
