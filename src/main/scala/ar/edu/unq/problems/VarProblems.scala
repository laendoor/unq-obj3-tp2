package ar.edu.unq.problems

import ar.edu.unq.program.WarningProblem
import ar.edu.unq.vars.{Ref, Var}

case class DuplicatedVarProblem(v: Var)
  extends WarningProblem(s"Variable ${v.key} was declared before", v)

case class VarReferencedWithoutDeclaringProblem(ref: Ref)
  extends WarningProblem(s"Variable ${ref.key} is used without declaring", ref)

case class VarDeclaredButNeverUsedProblem(v: Var)
  extends WarningProblem(s"Variable ${v.key} is declared but never used", v)

case class VarDeclaredReferenceNotValid(ref: Ref)
  extends WarningProblem(s"Varieble ${ref.key} is declared Not reference Valid",ref)

case class VarDeclaredNotUnassigned(v: Var)
  extends WarningProblem(s"Variable ${v.key} declared no asigned",v)