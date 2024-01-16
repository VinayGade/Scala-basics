package lectures.part6.recap

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object RecapAll extends App{

  val codeBlock = {
    if(true) 36
    else 42
  }

  //Unit = void     ...Return Type

  @tailrec def factorial(n: Int, acc: Int): Int =
    if(n <= 0) acc
    else factorial(n-1, n * acc)

  //Generics
  abstract class MyList[+A]
  object MyList              //singleton and companion

  //case class
  case class Person(name: String, age: Int)

  //Functional
  val increamenter = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  println("inc ="+increamenter(1))

  val anonymousIncr = (x: Int) => x + 1
  val list = List(1, 2, 3).map(anonymousIncr)

  println("anonymous Incr : ")
  list.foreach(print(_))

  println(" * * * * ")
  //map flatmap filter
  val pairs = for {
    num <- List(1, 2, 3)
    char <- List('a', 'b', 'c')
  } yield num + " " + char

  pairs.foreach(println)

  val phonediary = Map(
    "Vinay" -> 12345,
    "Shruti" -> 90835,
    "Monica" -> 24345
  )

  //Collection: Seq, Array, List, Vector, Map, Tuple

  val anoption = Some(10)

  //Give discount to Teenage students
  val vinay = Person("Vinay", 19)
  val smita = Person("Smita", 19)
  val shruti = Person("Shruti", 18)
  val shailesh = Person("Shailesh", 25)
  val rahul = Person("Rahul", 28)

  val people = List(vinay, smita, shruti, shailesh, rahul)

  val greeting = people.foreach(person => person
  match {
    case Person(name, age) => {
      if ( age > 12 && age < 20 )
        println(s"Person $name of age $age is eligible for discount")
    }
    case _ => println("Person is not eligible for discount")
  })

  val women = List("Wilma", "Betty")
  val men = List("Fred", "Barney")

  val couples = women zip men

  couples.foreach { println }

  val couplesMap = couples.toMap

  println(couplesMap)

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")

  println("\nStep 2: How to initialize a Sequence of donut prices")
  val donutPrices: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Elements of donut prices = $donutPrices")

  println("\nStep 3: How to use zip method to zip two collections")
  val zippedDonutsAndPrices: Seq[(String, Double)] = donuts zip donutPrices
  println(s"Zipped donuts and prices = $zippedDonutsAndPrices")

  println("\nStep 4: How to use unzip method to un-merge a zipped collections")
  val unzipped: (Seq[String], Seq[Double]) = zippedDonutsAndPrices.unzip
  println(s"Donut names unzipped = ${unzipped._1}")
  println(s"Donut prices unzipped = ${unzipped._2}")

}
