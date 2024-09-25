package com.playzone

trait TestTrait:

  val innerPf: PartialFunction[Any, Option[Unit]] = { case x: String => Some(()) }

  val outerPf_1: PartialFunction[Any, Any] = p =>
    innerPf(p) match
      case Some(_) => println("Something")

  val outerPf_2: PartialFunction[Any, Any]

  def run(): Unit =

    println()
    println(s"Running ${getClass().getSimpleName()}")

    println(s"innerPf.isDefinedAt(10): ${innerPf.isDefinedAt(10)}")
    println(s"innerPf.isDefinedAt(\"abc\"): ${innerPf.isDefinedAt("abc")}")

    try println(s"outerPf_1.isDefinedAt(10): ${outerPf_1.isDefinedAt(10)}")
    catch case _: MatchError => println("outerPf_1.isDefinedAt(10): MatchError")
    try println(s"outerPf_1.isDefinedAt(\"abc\"): ${outerPf_1.isDefinedAt("abc")}")
    catch case _: MatchError => println("outerPf_1.isDefinedAt(\"abc\"): MatchError")

    try println(s"outerPf_2.isDefinedAt(10): ${outerPf_2.isDefinedAt(10)}")
    catch case _: MatchError => println("outerPf_2.isDefinedAt(10): MatchError")
    try println(s"outerPf_2.isDefinedAt(\"abc\"): ${outerPf_2.isDefinedAt("abc")}")
    catch case _: MatchError => println("outerPf_2.isDefinedAt(\"abc\"): MatchError")
