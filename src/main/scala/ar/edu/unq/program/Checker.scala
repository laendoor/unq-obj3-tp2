package ar.edu.unq.program

import ar.edu.unq.program.AliasType.Rule

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
