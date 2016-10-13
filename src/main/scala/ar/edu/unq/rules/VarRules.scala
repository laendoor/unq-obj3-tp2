package ar.edu.unq.rules

import ar.edu.unq.problems.{DuplicatedVarProblem, VarDeclaredButNeverUsedProblem, VarReferencedWithoutDeclaringProblem}
import ar.edu.unq.program.AliasType._
import ar.edu.unq.program.{Boolean, Expression, Number, Sum}
import ar.edu.unq.vars.{Ref, Var}

object CheckerVarRules {

  val smart: CheckerGlobalRule = {

    case (v @ Var(_, None), expressions)
      if expressions.contains(v)
      && varIsDefinedBefore(v, expressions) => Some(DuplicatedVarProblem(v))

    case (r: Ref, expressions)
      if expressions.contains(r)
      && !refIsDefinedBefore(r, expressions) => Some(VarReferencedWithoutDeclaringProblem(r))

    case (v: Var, expressions)
      if expressions.contains(v)
      && !varIsUsed(v, expressions) => Some(VarDeclaredButNeverUsedProblem(v))

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
    val needle = Ref(v.key)
    splitAt(es, v)._2.flatMap {
      case `needle` => Some(v)
      case Sum(`needle`, _) => Some(v)
      case Sum(_, `needle`) => Some(v)
      case _ => None
    } nonEmpty
  }

}

object RefactorVarRules {

//  val smart: RefactorRule = {
//    case op: Equals   => equality(op)
//    case op: Distinct => inequality(op)
//    case op: Lesser   => lesser(op)
//    case op: Greater  => greater(op)
//    case op: LesserOrEqual  => lesserOrEqual(op)
//    case op: GreaterOrEqual => greaterOrEqual(op)
//    case expr => expr
//  }

}