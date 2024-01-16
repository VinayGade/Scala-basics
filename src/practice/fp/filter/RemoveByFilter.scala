package practice.fp.filter

object RemoveByFilter {

  def f(arr:List[Int]):List[Int] = arr.zipWithIndex.filter(_._2 % 2 != 0).map(_._1)

  def main(args: Array[String])=
  {
    val arr = List(2, 5, 3, 4, 6, 7, 9, 8)
    val output: List[Int] = f(arr)
    output.foreach(println(_))
  }
}
