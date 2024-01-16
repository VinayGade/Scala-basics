package lectures.part4.pattern.matching

import scala.util.Random

object PatternMatching extends App{

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 0 => "ZERO"
    case 1 => "ONE"
    case 2 => "TWO"
    case 3 => "THREE"
    case 4 => "FOUR"
    case _ => "Some other value"    //scala.MatchError  ...without case _
  }

  println(x)
  println(description)

  //Decompose values
  //Use of case class

  case class Person(name: String, age: Int)

  val vinay = Person("vinay", 27)
  val shruti = Person("shruti", 34)

  val greeting = shruti match {
    case Person(name, age) => s"Person ${name} is of age ${age} Today is ${name}'s birthday :) "
    case _ => "Don't know person"
  }

  println(greeting)


  class Animal
  case class Dog(breed: String) extends Animal
  case class Cat(sound: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val dog: Animal = Dog("Huskie")
  dog match {
    case Dog(breedValue) => s"My dog Rocky is of $breedValue breed."
  }

  /*
  * * Pattern Matching Rules :-)
  *
  * 1.  cases are matched in order.
  *
  * 2.  what if no cases match?  scala.MatchError  ...without case _
  *
  * 3.  Type of Pattern Matching expression?    Uniform type of all types in all cases
  *
  * 4.   Works extremely best with case classes and tuples
  *
  * */

  //Overwhelming code patterns

  val n = 10
  val isEven = if(n % 2 == 0) true else false

  val isEvenCase = n match {
    case n if n % 2 == 1 => true
    case _ => false
  }

  //Correct normal expression
  val isEvenNormal = ( n % 2 == 0 )


  /*  Take Expression and => Human readable expression

  1.  Sum(Number(2), Number(3))  =>  2 + 3
  2.  Sum(Number(2), Number(3), Number(4)) =>  =>  2 + 3 + 4
  3.  Sum(Prod(Number(2), Number(3)), Number(4))
  4.  Prod(Sum(Number(2), Number(1)), Number(3))
  */

  trait Expression
  case class Number(n: Int) extends Expression
  case class Product(e1: Expression, e2: Expression) extends Expression
  case class Sum(e1: Expression, e2: Expression) extends Expression

  def show(e: Expression): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1, e2) => {
      def showParantheses(exp: Expression) = exp match {
        case Product(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "( " + show(exp) + " )"
      }
      showParantheses(e1) + " * "+showParantheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show (Sum( Sum(Number(2), Number(3)), Number(4))) )
  println(show (Sum( Product(Number(2), Number(3)), Number(4))))
  println(show (Product( Sum(Number(2), Number(1)), Number(3))))

  println(show (Product( Sum(Number(2), Number(1)), Sum(Number(2), Number(3)))))
  println(show (Sum( Product(Number(2), Number(1)), Product(Number(2), Number(3)))))


  //Case with tuples

  val atuple = (1, 2)
  val matchATuple = atuple match {
    case (1, 2) =>
    case (somethng, 2) => s"I have found $somethng"
  }

  /*
  val nestedTuple = (2, (3, 4))
  val matchNestedTuple = nestedTuple match {
    case(_, (2, v)) =>
  }

   */

  /*
  val aList: List[Int] = Cons(1, Cons(2, Empty))
  val matchList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, sybtail)) =>
  }
   */

  //List patterns
  /*
  val numbers = List(10, 20, 30, 40)
  val standardMatching = numbers match {
    case List(1, _, _, _) =>  // extractor
    case List(1, _*) =>  //list of arbitrary length
    case 1 :: List(_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }

   */

  //Type Specifiers
  /*
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // Explicit type specifier
    case _ =>
  }

   */

  // Name binding

  // Multi Pattern Match

  //if gurads ... case with if statement at suffix


  //Erasure Problems
  val numList = List(1, 2, 3, 4)
  val numbersMatch = numList match {
    case listOfStrings: List[String] => "List of Strings"    //... List[String] => List by JVM without considering Generic type
    case listOfInts: List[Int] => "List of Int"               //...List[Int] => List by JVM without considering Generic type
    case _ => ""
  }

  println(numbersMatch)

  //Case for Exception Handling

  val numberList = List(51,71,80,83,88,91,96)
  val evens = for {
    x <- numberList if x % 2 == 0
  } yield x

  println(evens)

  val tupleList = List((10,20), (30,40))
  val mapTuples = for {
    (x, y) <- tupleList
  } yield (x * y)
  println(mapTuples)

  val tupleV1 = (1, 2, 3)
  val (a, b ,c) = tupleV1
  println(a + " "+ b + " " + c)

  val head :: tail = numberList
  println(head)
  println(tail)

  // pattern matching partial functions
  val mappedEvenList = numberList.map{
    case v if v%2 == 0 => v + "is even"
    case 1 => "One"
    case _ => "Something else"
  }

  val mappedEvenListMatch = numberList.map { x => x match {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "One"
    case _ => "Something else"
    }
  }

  println(mappedEvenList)
  println(mappedEvenListMatch)

}
