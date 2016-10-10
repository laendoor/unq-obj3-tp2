package ar.edu.unq.checker.numbers.comparisons

import ar.edu.unq.BaseSpec
import ar.edu.unq.numbers.{Equals, Number}

trait CheckEqualitySpec extends BaseSpec {

  "Check Equality" should s"$containAlwaysTrueComparisionWarningMessage if numbers are equals" in {
    expectAlwaysTrueComparisionWarning(0, 0)
    expectAlwaysTrueComparisionWarning(1, 1)
    expectAlwaysTrueComparisionWarning(2, 2)
  }

  it should s"$containAlwaysFalseComparisionWarningMessage if numbers are different" in {
    expectAlwaysFalseComparisionWarning(0, 1)
    expectAlwaysFalseComparisionWarning(1, 2)
    expectAlwaysFalseComparisionWarning(2, 3)
    expectAlwaysFalseComparisionWarning(3, 2)
    expectAlwaysFalseComparisionWarning(2, 1)
    expectAlwaysFalseComparisionWarning(1, 0)
  }

  def expectAlwaysTrueComparisionWarning(x: Int, y: Int)  = expectNonSenseComparisionWarning("True", x, y)
  def expectAlwaysFalseComparisionWarning(x: Int, y: Int) = expectNonSenseComparisionWarning("False", x, y)

  def expectNonSenseComparisionWarning(boolean: String, x: Int, y: Int) = {
    expectWarning(
      Equals(Number(x), Number(y)),
      s"Non-Sense Comparison: this comparison always gives $boolean"
    )
  }

}
