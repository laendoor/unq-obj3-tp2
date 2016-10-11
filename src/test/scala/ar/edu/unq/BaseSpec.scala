package ar.edu.unq

import ar.edu.unq.numbers.{ComparisonRules, OperationRules}

import ar.edu.unq.program.AliasType.CheckerRule
import ar.edu.unq.program._
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class BaseSpec extends FlatSpec
  with Matchers
  with BeforeAndAfter
