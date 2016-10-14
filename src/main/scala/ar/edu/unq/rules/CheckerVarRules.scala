package ar.edu.unq.rules

import ar.edu.unq.problems._
import ar.edu.unq.program.AliasType._
import ar.edu.unq.program.{Expression, Operation, Value}
import ar.edu.unq.vars.{Assign, Ref, Var}

object CheckerVarRules {

  val definitions: CheckerGlobalRule = {

    case (v @ Var(_, None), expressions)
      if expressions.contains(v)
      && varIsDefinedBefore(v, expressions) => Some(DuplicatedVarProblem(v))

    case (r: Ref, expressions)
      if expressions.contains(r)
        && !refIsDefinedBefore(r, expressions) => Some(VarReferencedWithoutDeclaringProblem(r))

    case _ => None
  }

  val uses: CheckerGlobalRule = {

    case (v: Var, expressions)
      if expressions.contains(v)
      && !varIsUsed(v, expressions) => Some(VarDeclaredButNeverUsedProblem(v))

    case (r: Ref, expressions)
      if expressions.contains(r)
      && !refHasValueAssigned(r, expressions) => Some(VarUsedButNeverAssignedProblem(r))

    case _ => None
  }

  def varIsDefinedBefore(v: Var, es: List[Expression]) = previousVarKeys(v, es) contains v.key

  def refIsDefinedBefore(r: Ref, es: List[Expression]) = previousVarKeys(r, es) contains r.key

  def previousVarKeys(e: Expression, es: List[Expression]): List[String] = previousVars(e, es) map { v0 => v0.key }

  def previousVars(e: Expression, es: List[Expression]): List[Var] = splitAt(es, e)._1.flatMap {
    case v: Var => Some(v)
    case _ => None
  }

  def splitAt(es: List[Expression], e: Expression) = es splitAt (es indexOf e)

  def varIsUsed(v: Var, es: List[Expression]): scala.Boolean = {
    val ref = Ref(v.key)
    splitAt(es, v)._2 exists {
      case `ref` => true
      case v: Operation if List(v.x, v.y) contains `ref` => true
      case _ => false
    }
  }

  def refHasValueAssigned(r: Ref, es: List[Expression]): scala.Boolean = {
    splitAt(es, r)._1 exists {
      case Var(r.key, Some(_)) => true
      case Assign(Ref(r.key), _) => true
      case _ => false
    }
  }

}