package practice.collections.list

object ListDemo extends App{

  val double = (i: Int) => { i * 2 }

  println(double(2))
  println(double(10))

  val list = List.range(1, 5)

  println(list)
  list.map(double)
  println("After mapping function")
  println(list)

}
