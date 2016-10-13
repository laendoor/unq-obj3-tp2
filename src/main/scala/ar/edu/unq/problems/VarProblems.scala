package ar.edu.unq.problems

import ar.edu.unq.program.WarningProblem
import ar.edu.unq.vars.{Ref, Var}

case class DuplicatedVarProblem(variable: Var)
  extends WarningProblem(s"Variable ${variable.key} was declared before", variable)

case class VarReferencedWithoutDeclaringProblem(ref: Ref)
  extends WarningProblem(s"Variable ${ref.key} is used without declaring", ref)

