package lectures.part3.functional

object ImportantScalaFunctions extends App{

  val list = List(10, 20 ,30)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_*2))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  val listChars = List('a','b','c')
  val numlist = List(1, 2, 3, 4)

  val colors = List("Black", "Maroon", "Navy Blue")

  val pair = (a: Char, b: Int) => List(a+" - "+b)

  case class Person(id: Int, name: String)
  /*
  case class Customer extends Person(, String){
    val cardNumber: String
    
  }

   */

  //val combinations : List[String] = numlist.flatMap(n => listChars.map( c => c + "-" + n))
  val combinations : List[String] = numlist.flatMap(n => listChars.map( _ + " - " + n))   //...nested for loop

  val combinationColors = numlist.flatMap(n => listChars.flatMap( ch => colors.map( c => ch + " - " + n + " - " + c)))   // ...3 * for

  println("\n * * * * * char - number * * * * * ")

  combinations.foreach(println)

  println("\n * * * * * char - number - color * * * * * ")

  combinationColors.foreach(println)

  println("\n * * * * * The Simplest Way * * * * * ")
  // For combinations
  val forCombinations = for {
    n <- numlist
    c <- listChars
    color <- colors
  } yield ""+ c + " - " + n + " - " + color

  forCombinations.foreach(println)

  println("\n * * * * * The Simplest Way => Only for even numbers * * * * * ")
  val forCombinationsEven = for {
    n <- numlist  if( n % 2 == 0 )
    //n <- numlist  numlist.filter(_%2==0)
    c <- listChars
    color <- colors
  } yield ""+ c + " - " + n + " - " + color

  forCombinationsEven.foreach(println)

  for {
    color <- colors
  } println(color)

  val mul3list = numlist.map { x =>
    x * 3
  }
  mul3list.foreach(println)

}
