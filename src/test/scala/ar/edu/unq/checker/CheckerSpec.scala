package ar.edu.unq.checker

import ar.edu.unq.checker.numbers.{CheckComparisionSpec, CheckNumberSpec, CheckOperationSpec}

class CheckerSpec extends BaseCheckerSpec
  with CheckNumberSpec
  with CheckOperationSpec
  with CheckComparisionSpec
