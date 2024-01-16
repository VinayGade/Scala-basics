package practice.fp.filter

/* input
2 -4 3 -1 23 -4 -54
* */

/*output
2
4
3
1
23
4
54
* */
object AbsoluteValues extends App{

  def f(arr:List[Int]):List[Int] = arr.map(_.abs)

  val list = List(2, -4, 3, -1, 23, -4, -54)

  println(f(list))
}
