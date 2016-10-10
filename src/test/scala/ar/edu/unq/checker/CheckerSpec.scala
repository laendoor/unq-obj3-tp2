package ar.edu.unq.checker

import ar.edu.unq.BaseSpec
import ar.edu.unq.checker.numbers.{CheckComparisionSpec, CheckNumberSpec, CheckOperationSpec}

class CheckerSpec extends BaseSpec
  with CheckNumberSpec
  with CheckOperationSpec
  with CheckComparisionSpec
