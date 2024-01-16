package lectures.part3.functional

object AnonymousFunctionDemo extends App{

  val doubler : Int => Int = (x: Int) => x * 2   // Anonymous Function == Lambda expression

  val square = (x: Int) => x * x

  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y

  val doSomething = () => 3.14

  //Always call lambda function with ()
  println(doSomething)
  println(doSomething())

  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  val increamenter: Int => Int = _ + 1 // x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //// (a, b) => a + b

  println(stringToInt("20"))
  println(increamenter(15))
  println(niceAdder(25, 35))

  val list = List(10,20 ,30 ,40 ,50)

  //val listMul2 = list.map(x => x * 2)
  val listMul2 = list.map(_ * 2)

  //val listMod20 = list.filter(x => x % 20 == 0)
  val listMod20 = list.filter(_ % 20 == 0)

  println(listMul2)
  println(listMod20)

  val fruits = Seq("apple", "banana", "orange")
  val upperFruits = fruits.map(_.toUpperCase)
  val UpperFruits2 = fruits.flatMap(_.toUpperCase)

  println(fruits)
  println(upperFruits)
  println(UpperFruits2)

  /*
  * flatMap => it flattens the resulting list of strings into a sequence of characters (Seq[Char]).
  * flatMap = map + flatten
  * */

  //flatMap with option
  val strings = Seq("1", "2", "10", "3", "33")
  val ints: Seq[Int] = strings.map(_.toInt)
  println(ints)

  val listnos = List(1,2,3,4,5)
  def g(v:Int) = List(v-1, v, v+1)
  val mappedList = listnos.map(x => g(x))
  val flattenList = listnos.flatMap(x => g(x))

  println(listnos)
  println(mappedList)
  println(flattenList)

}
