package ar.edu.unq.rules

import ar.edu.unq.problems.DuplicatedVarProblem
import ar.edu.unq.program.AliasType._
import ar.edu.unq.program.Expression
import ar.edu.unq.vars.Var

object CheckerVarRules {

  val smart: CheckerGlobalRule = {
    case (v @ Var(key, None), expressions)
      if expressions.contains(v) && isDefinedBefore(v, expressions) => Some(DuplicatedVarProblem(v))
    case _ => None
  }

  /**
    * Detecta si una Var fue definida en una expresión anterior.
    *
    * Metodología: Se parte la lista de expresiones en dos a través de la variable buscada.
    * @param v
    * @param expressions
    * @return
    */
  def isDefinedBefore(v: Var, expressions: List[Expression]) = {

    val vars: List[Var] = expressions.splitAt(expressions.indexOf(v))._1.flatMap {
      case v: Var => Some(v)
      case _ => None
    }

    vars.map { v0 => v0.key } contains v.key
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