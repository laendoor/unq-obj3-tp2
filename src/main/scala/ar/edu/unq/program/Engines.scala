package ar.edu.unq.program

import ar.edu.unq.program.AliasType.{CheckerRule, RefactorRule}

/**
  * Un Chequeador recibe un programa y una lista de reglas de chequeo.
  *
  * Aplica las reglas a las expresiones del programa.
  *
  * Retorna una lista de Problemas
  */
object Checker {
  def apply(program: Program, rules: List[CheckerRule]) = program.expressions flatMap { exp => checkRules(exp, rules) }

  def checkRules(expression: Expression, rules: List[CheckerRule]) = rules flatMap { rule => rule(expression) }
}

/**
  * Un Refactor recibe un programa y una lista de reglas de refactor.
  *
  * Aplica las reglas a las expresiones del programa.
  *
  * Retorna otro Programa (refactorizado)
  */
object Refactor {

  def apply(program: Program, rules: List[RefactorRule]): Program = {
    Program(rules.foldLeft(program.expressions) {(exprs,rule) => refactorRules(rule,exprs)})
  }

  def refactorRules(rule: RefactorRule, expressions: List[Expression]) = expressions map rule
}

/**
  * Un Intérprete recibe un programa.
  *
  * Ejecuta cada una de las Expresiones del Programa.
  *
  * Retorna el último Valor de los resultados de ejecutar las expresiones.
  *
  */
object Interpreter {

  def apply(program: Program): Value = {
    execute(program.expressions) match {
      case Nil => Boolean(false)
      case values: List[Value] => values.last
    }
  }

  def execute(expressions: List[Expression]): List[Value] = expressions map { e => e.execute }

}
