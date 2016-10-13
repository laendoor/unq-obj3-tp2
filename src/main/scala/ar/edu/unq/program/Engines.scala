package ar.edu.unq.program

import ar.edu.unq.program.AliasType.{CheckerGlobalRule, CheckerRule, RefactorRule}

/**
  * Un Chequeador recibe un programa y una lista de reglas de chequeo.
  *
  * Aplica las reglas a las expresiones del programa.
  *
  * Retorna una lista de Problemas
  */
object Checker {
  def apply(program: Program, exprsRules: List[CheckerRule], globalRules: List[CheckerGlobalRule]) = {
    val globalProblems     = program.expressions flatMap { exp => checkGlobalRules(exp, program.expressions, globalRules) }
    val expressionProblems = program.expressions flatMap { exp => checkRules(exp, exprsRules) }
    globalProblems ::: expressionProblems
  }

  def checkRules(expression: Expression, rules: List[CheckerRule]) = rules flatMap { rule => rule(expression) }
  def checkGlobalRules(e: Expression, es: List[Expression], rules: List[CheckerGlobalRule]) = rules flatMap { rule => rule((e, es)) }
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
    val expressions = rules.foldLeft(program.expressions) {(exprs,rule) => refactorRules(rule,exprs)}
    new Program(expressions, program.memory)
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
    execute(program) match {
      case Nil => Boolean(false)
      case values: List[Value] => values.last
    }
  }

  def execute(program: Program): List[Value] = program.expressions map { e => e.executeIn(program.memory) }

}
