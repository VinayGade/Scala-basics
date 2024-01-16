package lectures.part2.oop

object GenericList extends App{
  /*
 Implement a List with following operations
 1. head is the first element
 2. tail is the last element
 3. isEmpty
 4. add int
 5. toString is string representation of the List
 * */
  abstract class MyList[+A] {

    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](i: B): MyList[B]

    def printElements: String

    override def toString: String = "[" + printElements + "]"
  }

  object Empty extends MyList[Nothing]{
    override def head: Nothing = throw new NoSuchElementException

    override def tail: MyList[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def add[B >: Nothing](i: B): MyList[B] = new Cons(i, Empty)

    override  def printElements: String = ""
  }

  class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    override def head: A = h

    override def tail: MyList[A] = t

    override def isEmpty: Boolean = false

    override def add[B >: A](i: B): MyList[B] = new Cons(i, this)

    override  def printElements: String =
      if(t.isEmpty) " "+ h
      else h + " " + t.printElements
  }

/*
  val list = new Cons(10, Empty)
  val list2 = new Cons(10, new Cons(20, new Cons(30, Empty)))
  println(list.head)
  println(list2.tail.head)
  list2.add(40)
  println(list2.head)

  println(list2.toString)

 */

  val listOfInts : MyList[Int] = Empty
  val listOfStr: MyList[String] = Empty

  val listOfNums = new Cons(10, new Cons(20, new Cons(30, Empty)))
  val listOfStrings: MyList[String] = new Cons("Welcome to", new Cons("Scala", new Cons("2.12"+" Version", Empty)))

  println(listOfNums.toString)
  println(listOfStrings.toString)

}
