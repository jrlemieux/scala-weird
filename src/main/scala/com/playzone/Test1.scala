package com.playzone

class Test1() extends TestTrait:

  val outerPf_2: PartialFunction[Any, Any] = p =>
    val something = p
    innerPf(p) match
      case Some(_) => println("Something")
