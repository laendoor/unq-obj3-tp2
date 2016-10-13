package ar.edu.unq.problems

import ar.edu.unq.program.WarningProblem
import ar.edu.unq.vars.Var

case class DuplicatedVarProblem(variable: Var)
  extends WarningProblem(s"Variable ${variable.key} was declared before", variable)

