package ar.edu.unq.program

import ar.edu.unq.program.AliasType.{RefactorRules, Rule}

/**
  * Un chequeador recibe un programa y una lista de reglas
  * y aplica las reglas a las expresiones del programa
  */
object Checker {
  def apply(program: Program, rules: List[Rule]): List[Problem] = {
    program.expressions.flatMap(exp => checkRules(exp, rules))
  }

  def checkRules(expression: Expression, rules: List[Rule]): List[Problem] = {
    rules.flatMap(rule => rule(expression))
  }
}

object refactor {

  def apply(program: Program, rules: List[RefactorRules]): Program= {
    Program(rules.foldLeft(program.expressions){(exprs,rule)=> refactorRules(rule,exprs)})
  }

  def refactorRules(rule: RefactorRules,expressions: List[Expression]) = {
    expressions.map {e => rule(e) }
  }
}

object Interprete {

  def apply(program: Program): List[Expression] = {
    executer(program.expressions)
  }

  def executer(exp: List[Expression]): List[Expression] = {
    //val resultList = List[Value]
    exp match {
      case Nil => Nil
      case x :: xs => x.run :: executer(xs)

    }
  }

}
