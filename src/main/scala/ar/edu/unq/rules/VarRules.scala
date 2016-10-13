package ar.edu.unq.rules

import ar.edu.unq.program.AliasType._

object CheckerVarRules {
  val smart: CheckerGlobalRule = {
    case Nil => None
//    case expressions => Some(DuplicatedVarProblem(v))
//    case op: Distinct => inequality(op)
//    case op: Lesser   => lesser(op)
//    case op: Greater  => greater(op)
//    case op: LesserOrEqual  => lesserOrEqual(op)
//    case op: GreaterOrEqual => greaterOrEqual(op)
    case _ => None
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