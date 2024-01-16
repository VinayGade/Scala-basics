package lectures.part2.oop

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  //Anonymous inner class (sub class) of Animal
  // it works for Traits and classes
  val funny: Animal = new Animal{
    override def eat: Unit = println("Whales Snoooozing")
  }

  println(funny.getClass.getName)
}
