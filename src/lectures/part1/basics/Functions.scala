package lectures.part1.basics

import scala.annotation.tailrec

object Functions extends App{
  def area ( a: Int, b: Int) : Int = a * b

  def concat ( s1: String, s2: String) : String = s1 + s2

  println("area :"+area(10,20))
  println("concat :"+concat("Scala-","2.12"))

  //When you need loops use RECURSION

  def factorial( n: Int): Int =    // StackOverflowError if n = 5000
    if( n <= 1) 1
    else n * factorial(n-1)

  def fibonacci( n: Int): Int =
    if( n <= 2 ) 1
    else fibonacci(n-1) + fibonacci(n-2)


  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x-1, x * accumulator)   // Tail RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1 )
  = factHelper(8, 9 * 10 * 1 )
  = factHelper(7, 8 * 9 * 10 * 1 )
  = factHelper(6, 7 * 8 * 9 * 10 * 1 )
  = factHelper(5, 6 * 7 * 8 * 9 * 10 * 1 )
  = factHelper(4, 5 * 6 * 7 * 8 * 9 * 10 * 1 )
  = factHelper(3, 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1 )
  = factHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1 )
  = factHelper(1, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1 )
  = factHelper(0, 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10  )
  = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
   */

  /*

  Tail Recursion
  1. Concatenate String n times
  2. isPrime
  3. fibonacci
   */

  def tailRecConcatenate(string: String, n: Int, accumulator: String): String = {
    if(n == 0) accumulator
    else tailRecConcatenate(string, n - 1, "\n"+ string + accumulator)
  }

  def tailRecIsPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeTailRec(t : Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if(t<=1) true
      else isPrimeTailRec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n/2, true)
  }

  def tailRecFibonacci(n: Int): Int = {

    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if(i>=n) last
      else fiboTailRec(i+1, last + nextToLast, last)

    if(n<=2) 1
    else fiboTailRec(3, 1, 1)
  }

  println("Factorial 5 = "+factorial(5))
  println("fibonacci 5 = "+fibonacci(5))

  println("Tail Recursion ::")
  println("concat" + tailRecConcatenate("Scala 2.12", 10, ""))

  println("2003 is prime:" + tailRecIsPrime(2003))

  println("Tail Recursive Fibonacci:" + tailRecFibonacci(10))

  println("* * * * * * ")

  println("Another Factorial of 10 = "+anotherFactorial(10))
  println("Another Factorial of 5000 = "+anotherFactorial(5000))   //returns 0 if Return Type : Int/ Long

  def repeatString( string: String, frequency: Int): String = {
    if(frequency == 1) string
    else string + "\n" +repeatString(string, frequency-1)
  }

  println("Welcome Scala 5 times ::\n" + repeatString("Welcome Scala", 5))

  def outerArea( a: Int, b: Int, r:Int, shape: String) = {
    val PI = 3.14
    def innerAreaRect (a: Int, b: Int) = a * b
    def innerAreaCircle (r:Int) = PI * r * r

    if(shape == "Circle")
      innerAreaCircle(r).toInt
    else if(shape == "Rectangle")
      innerAreaRect(a,b)
  }

  println("area (10, 20, Rectangle) :"+outerArea(10, 20, 0, "Rectangle"))
  println("area (10, Circle) :"+outerArea(0, 0, 10, "Circle"))

  def isPrime(n : Int): Boolean = {
    def isPrimeUntil(t : Int): Boolean =
      if(t <= 2)  true
      else  n%t!=0 && isPrimeUntil(n-1)
    isPrimeUntil(n/2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))

  def displayMessage() = println("Scala 2.12")
  def displayMessage1 = println("Scala 2.12")

  println(displayMessage)

}
