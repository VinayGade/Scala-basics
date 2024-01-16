package lectures.part2.oop

object Exceptions extends App{

  val x: String =null
  //println(x.length)       //... NullPointerException

  // Throwing and Catching exceptions
  //val wierdValue = throw new NullPointerException

  //Exception and Error are major Throwable subtypes.

  //catch Exception

  def getInt( flag : Boolean): Int =
    if(flag)  throw new RuntimeException
    else  42

  val buggyCode = try {
    getInt(true)
  } catch {
    case npe: NullPointerException => println("Caught NullPointerException...")
    case e: RuntimeException => println("Caught Runtime Exception...")
  } finally {
    //Use for side effects "Logging INFO, Errors or warnings"
    println("Finally getInt execution completed...")
  }

  println(buggyCode)

  /*
  1. OutOfMemoryError: Memory

  2. StackOverflowError

  3. PocketCalculator

      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide(x, y)

      throw new OverflowException if add(x, y) >= MAX
      throw new UnderflowException if subtract(x, y) >= MIN
      throw new MathCalculationException if divide by zero

   */

  //OutOfMemoryError
  //val array = Array.ofDim(Int.MaxValue)

  //StackOverflowError
  //def infinite: Int = 1 + infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class DivideByZeroException extends RuntimeException

  object PocketCalculator{

    def add(x: Int, y: Int): Int ={
      val result = x + y
      if (result > Int.MaxValue) throw new OverflowException
      else result
    }

    def subtract(x: Int, y: Int): Int ={
      val result = x - y
      if(result < Int.MinValue) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = x * y


    def divide(x: Int, y: Int): Int = {
      if (y!=0 ) x / y
      else throw new DivideByZeroException
    }

  }

  val result =
    try {
      val calculate = PocketCalculator
      println(calculate.add(10, 20))
      println(calculate.subtract(20, 10))
      println(calculate.multiply(10, 20))
      println(calculate.divide(100, 20))
      println(calculate.divide(15, 0))
    }

    catch{
      case dbz: DivideByZeroException   => println("Divide by zero gives infinite result ...")
      case ofe: OverflowException => println("Stack Overflow")
      case ufe: UnderflowException => println("Stack Underflow")
    }

    finally{
      println("Execution of Calculator operations completed")
    }

}
