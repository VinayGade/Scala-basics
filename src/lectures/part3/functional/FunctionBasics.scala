package lectures.part3.functional

object FunctionBasics extends App{

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val stringToInt = new Function1[String, Int]{
    override def apply(v1: String): Int = v1.toInt
  }

  val adder = new Function2[Int, Int, Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val adder1: ((Int, Int) => Int) = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int): Int = a + b
  }

  //Function2[n1, n2, result] === (n1, n2) => result

  //All Functions are Objects or instances of Function2, Function1,...

  println(doubler(20))
  println(stringToInt("10")+20)

  //Concatenate String
  def concatenate: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1.concat(v2)
  }

  println(concatenate("Hello", "Vinay"))
}

trait MyFunction[A, B]{
  def apply(element: A): B
}