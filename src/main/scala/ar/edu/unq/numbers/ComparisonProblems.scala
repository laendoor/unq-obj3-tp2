package ar.edu.unq.numbers

import ar.edu.unq.program.WarningProblem

abstract class NonSenseComparisionProblem(description: String, cmp: Comparison)
  extends WarningProblem(s"Non-Sense Comparison: $description", cmp)

case class TrueComparisonProblem(cmp: Comparison)
  extends NonSenseComparisionProblem("this comparison always gives True", cmp)

case class FalseComparisonProblem(cmp: Comparison)
  extends NonSenseComparisionProblem("this comparison always gives False", cmp)
