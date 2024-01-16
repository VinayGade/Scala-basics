package lectures.part2.oop

object Generics extends App{

  class MyList[+A]{
    //def add(element: A) : MyList[A] = ???
    def add[B >: A](element: B) : MyList[B] = ???

    /**
     Explanation:

     B super A
     if element is type A return List[A]
     if element is type B (which is super to A) convert existing list to List[B], add element to B and return B
     */
  }

  class MyMap[Key, Value]

  val numbers = new MyList[Int]
  val words = new MyList[String]

  // generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyNums = MyList.empty[Int]

  //Variance problems
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //List[Cat] extends List[Animal]
  class CovariantList[+A]
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // Can we add Dog to animalList?
  // Ans: Yes It will conver List[Cat] to generic CovariantList[Animal]
  // See method signature add() in MyList

  //Contravarience problems
  class Trainer[-A]
  val trainers: Trainer[Cat] = new Trainer[Animal]

  //Bounded types
  class Cage[A <: Animal](animal: A)    // <A extends Animal>
  val cage = new Cage(new Dog)

  class SupCage[A >: Dog](animal: A) // <A super Dog>  ... A = Dog / A = Animal

}
