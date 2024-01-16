package practice.fp.filter

import scala.io.StdIn

object FilterNumbers {

  def f(delim: Int, arr: List[Int]): List[Int] = arr.filter(_ < delim)

  def main(args: Array[String])
  {
    // prints Hello World
    println("Hello World!")
    val result = StdIn.readLine()
    println("Entered String : "+ result)
    val x = StdIn.readInt()
    println("x: "+ x)
    val arr: List[Int] = List(10, 9, 8, 2, 7, 5, 1, 3, 0)
    val output: List[Int] = f(x, arr)
    output.foreach(println(_))
  }
}
