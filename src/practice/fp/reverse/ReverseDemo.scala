package practice.fp.reverse
import scala.collection.mutable._

object ReverseDemo extends App{
  def f(arr:List[Int]):List[Int] = arr.reverse

    val arr = List(2, 5, 3, 4, 6, 7, 9, 8)
    println(f(arr))


}
