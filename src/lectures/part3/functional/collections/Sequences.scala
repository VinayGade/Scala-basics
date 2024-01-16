package lectures.part3.functional.collections

import scala.util.Random

/*
Sequences : List, Array, Vector
* */
object Sequences extends App{

  //Seq
  println("\n* * * * * * * * * * * * * Seq * * * * * * * * * * * * ")
  val numSequence: Seq[Int] = Seq(100,20, 50, 40, 30)
  println("numSequence : " + numSequence)
  println("numSequence.size : "+ numSequence.size)
  println("numSequence.reverse : " + numSequence.reverse)
  println(numSequence ++ Seq(60, 70 ,80))

  val appendSequence = numSequence ++ Seq(60, 70 ,80)
  println("appendSequence : " + appendSequence)
  println("appendSequence.sorted : " + appendSequence.sorted)

  // Ranges

  println("\n* * * * * * * * * * * * * Ranges * * * * * * * * * * * * ")
  val numRange: Seq[Int] = 1 to 5
  numRange.foreach(print)

  println("")
  (1 to 5).foreach(x => print("Scala "))

  println("")
  (1 until 5).foreach(x => print("Scala "))

  println("\n* * * * * * * * * * * * * List * * * * * * * * * * * * ")

  //List
  val numList = List(10, 20, 30)
  val prepended = 45 :: numList
  println("prepended : " + prepended)

  val appended = numList :+ 90
  println("appended : " + appended)

  val prependedAppended =  5 +: prepended :+ 80
  println("prependedAppended : " + prependedAppended)

  val apples5 = List.fill(5)("Apple")
  println("Fill apples list : " + apples5)
  println("Convert List to String : " + numList.mkString("-"))

  //Arrays
  val numbers = Array(1, 2, 3)
  val nums3 = Array.ofDim[Int](3)
  nums3.foreach(println)

  val strArr = Array.ofDim[String](3)
  strArr.foreach(println)

  numbers(2) = 5 //numbers.update(2, 5)

  //numbers(3) = 5  // ArrayIndexOutOfBoundsException: 3
  println(numbers.mkString(" "))

  //Array and Seq
  val numSeq: Seq[Int] = numbers // Implicit Conversion
  println("Number Sequence :" + numSeq) // WrappedArray(1, 2, 5)

  // Vector
  val vector: Vector[Int] = Vector(1, 2, 5)
  println("vector : "+vector)

  // Vectors vs List

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val random = new Random
    val times = for {
      i <-1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(random.nextInt(maxCapacity), random.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println("List Time : "+getWriteTime(numbersList))
  println("vector Time : "+getWriteTime(numbersVector))

  /*
  List
  1. saves element to tail
  2. Update at a position is slow/ inefficient

  Vector
  32 elements in vector. Once update or insert performed traverse entire collection and replace entire old chunk of elements
  Depth of vector tree is small.

  disadvantage: It need to replace entire 32 elements chuck.
  * */
}
