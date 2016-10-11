package ar.edu.unq.program

import ar.edu.unq.program.AliasType.{CheckerRule, RefactorRule}

/**
  * Un chequeador recibe un programa y una lista de reglas
  * y aplica las reglas a las expresiones del programa
  */
object Checker {
  def apply(program: Program, rules: List[CheckerRule]) = program.expressions flatMap { exp => checkRules(exp, rules) }

  def checkRules(expression: Expression, rules: List[CheckerRule]) = rules flatMap { rule => rule(expression) }
}

object Refactor {

  def apply(program: Program, rules: List[RefactorRule]): Program = {
    Program(rules.foldLeft(program.expressions) {(exprs,rule) => refactorRules(rule,exprs)})
  }

  def refactorRules(rule: RefactorRule, expressions: List[Expression]) = expressions map rule
}

object Interpreter {

  def apply(program: Program) = Program(execute(program.expressions))

  def execute(expressions: List[Expression]) = expressions map { e => e.execute }

}
