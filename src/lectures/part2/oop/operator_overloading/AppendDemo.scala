package lectures.part2.oop.operator_overloading

import scala.collection.mutable.ListBuffer

object AppendDemo extends App{

  println("Operator Overloading Demo")


  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour

  println("** Append **")
  println(oneTwo +" and "+ threeFour +" were not mutated.")
  println("Thus, "+ oneTwoThreeFour +" is a new list.")

  val twoThree = List(2, 3)
  val oneTwoThree = 1 :: twoThree
  println("** Prepend **")
  println(oneTwoThree)

  val one23 = 1 :: 2 :: 3 :: Nil
  println(one23)

  var months = List[String]()
  months = months ::: List("Jan", "Feb", "Mar", "Apr", "May")
  months = months ::: List("Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
  println(months)

  val PI =3.14
}