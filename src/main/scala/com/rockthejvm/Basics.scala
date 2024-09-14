package com.rockthejvm


// Extending "App" make the object Executable as a Standalone application
object Basics extends App {

  // defining a value (constants) --> reassigning to a val is illegal.
  val meaningOfLife: Int = 42  // java equivalent ==> const int meaningOfLife = 42;

  //  In scala we don't always have to define the type (with some exceptions).
  // Type's=> Int, Boolean, Char, Double, Float, String
  val meaningOfLife1 = 40 // type is optional


  //String and String Operation
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"My I'm saying is $meaningOfLife"

  // In Scala try to develop the habit of thinking in-terms of vales and expressions
  // When you define a val in Scala the right hand side is an expression (This can me in various forms)

  // expression = structures that can be reduced to value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if(meaningOfLife > 43) 56 else 999 // in java=> meaningOfLife > 43 ? 56 : 999

  val chainedIfExpression =
    if(meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // defination
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive function
  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n-1)

  // In Scala we don't use loops or iterations, we use RECURSION !!

  // The Unit return type = no meaningful value === "void" in other languages
  // type of SIDE EFFECTS
  println(" I love Scala")

  def myUnitReturningFunction(): Unit = {
    print("In don't return anything")
  }

}
