package practice.fp.flatMap

import scala.io.StdIn

object RepeatingNums {
  def main(args: Array[String])=
  {
    val s = StdIn.readInt()
    println("s: "+ s)
    val arr: List[Int] = List( 1, 2, 3, 4)
    val output: List[Int] = f(s, arr)
    output.foreach(println(_))
  }

  def f(num:Int,arr:List[Int]):List[Int] = arr.flatMap(List.fill(num)(_))

}
