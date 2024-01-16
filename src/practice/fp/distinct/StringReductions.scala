package practice.fp.distinct

import scala.io.StdIn

object StringReductions extends App{

  val input: String = StdIn.readLine()
  /*
  val arr = input.toCharArray
  val set = arr.distinct.toSet
  set.foreach(print)
   */

  input.toCharArray.distinct.foreach(print)

}
