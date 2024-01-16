package lectures.part1.basics

object RangesDemo extends App {

  println("1 to 10")
  val range = 1 to 10
  range.foreach(println)

  println("1 to 9")
  val range1 = 1 until 10
  range1.foreach(println)

  println("Step 3")
  val divideBy3 = 0 to 10 by 3
  divideBy3.foreach(println)

  println("Step -3 Descending order")
  val step3Reverse = 10 to 1 by -3
  step3Reverse.foreach(println)

  println("Type Float step ")
  val floatStep = 1.1f to 10.3f by 3.1f
  floatStep.foreach(println)

  println("Type Double step ")
  val doubleStep = 0.1 to 10.3 by 3.1
  doubleStep.foreach(println)

  println("5 th alphabet")
  val charStep = 'a' to 'z' by 5
  charStep.foreach(println)

}
