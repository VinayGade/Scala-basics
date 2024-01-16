package practice.fp.count
// count elements with FP
object CountElements {

  def f(arr:List[Int]): Int = {
    var count:Int = 0
    if(arr.nonEmpty)
      for(i <- arr)
        count += 1
    count
  }

  def main(args: Array[String])=
  {
    val arr = List(2, 5, 3, 4, 6, 7, 9, 8)
    println(f(arr))

  }
}
