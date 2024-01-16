package practice.fp.count

import scala.collection.mutable


object Solution extends App {

  def f(num:Int) : List[Int] =
     0 until num toList


  println(f(scala.io.StdIn.readInt))
}