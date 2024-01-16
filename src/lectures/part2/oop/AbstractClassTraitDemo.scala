package lectures.part2.oop

object AbstractClassTraitDemo extends App {

  abstract class Animal {
    val name: String
    val family: String

    def eat: Unit
  }

  class Dog extends Animal {
    override val family: String = "Canis lupus"

    override def eat: Unit = println("Dog eats chicken and biscuits")

    override val name: String = "Huskie"
  }

  class Cat extends Animal {
    override val family: String = "Felidae"

    def eat: Unit = println("Cat eats fish, milk and protein seeds")

    override val name: String = "American Shorhair"
  }

  class Cow extends Animal {
    override val family: String = "Bos taurus"

    def eat: Unit = println("Cow eats fresh grass, dry grass, wheet grass and grains")

    override val name: String = "Indian Gir Gavaa"
  }

  trait Carnivores {
    def eat(animal: Animal): Unit

    val preferredMeal = "Fresh Meat"
  }

  class Crocodiles extends Animal with Carnivores {
    override val family: String = "Reptilia"
    override val name: String = "Crocodile"

    override def eat: Unit = println("Crocodile eats Beef")

    override def eat(animal: Animal): Unit = println(s"Crocodile eats ${animal.name} of family ${animal.family} ")
  }

  val wildBull = new Cow
  val croc = new Crocodiles

  //croc eat
  croc eat wildBull

  /*
  Abstract class vs trait
  1.  Traits don't have constructor parameters
  2.  Multiple traits can be inherited by same class.
  3.
  * */

  /*
  Implement a List with following operations
  1. head is the first element
  2. tail is the last element
  3. isEmpty
  4. add int
  5. toString is string representation of the List
  * */
  abstract class MyList {

    def head: Int

    def tail: MyList

    def isEmpty: Boolean

    def add(i: Int): MyList

     def printElements: String

    override def toString: String = "[" + printElements + "]"
  }

  object Empty extends MyList{
    override def head: Int = throw new NoSuchElementException

    override def tail: MyList = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def add(i: Int): MyList = new Cons(10, Empty)

    override  def printElements: String = ""
  }

  class Cons(h: Int, t: MyList) extends MyList{
    override def head: Int = h

    override def tail: MyList = t

    override def isEmpty: Boolean = false

    override def add(i: Int): MyList = new Cons(i, this)

    override  def printElements: String =
      if(t.isEmpty) " "+ h
      else h + " " + t.printElements
  }


    val list = new Cons(10, Empty)
    val list2 = new Cons(10, new Cons(20, new Cons(30, Empty)))
    println(list.head)
    println(list2.tail.head)
    list2.add(40)
    println(list2.head)

    println(list2.toString)
}
