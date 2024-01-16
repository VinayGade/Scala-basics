package lectures.part2.oop

object InheritanceDemo extends App{

  //Single class inheritance
  sealed class Animal {           // Animal cannot be inherited outside InheritanceTraitsDemo
    def sounds: String= "nothing"
  }

  class Cat extends Animal{
    def sounds(mode: String): String = if(mode == "sleep") "purr" else if(mode == "hungry") "Meaw meaw" else "me"
    override def sounds: String = "mew"
  }

  class Dog extends Animal{
    override def sounds: String = "Whauo Bhauooo"
    def sounds(mode: String): String = if(mode == "hungry") "haee haee" else if(mode == "angry") "haurr raughh raww whaw" else if("pain" == mode) "hueee kuee" else "hurrm"
  }

  val cat = new Cat
  println( cat sounds)
  println(cat sounds "hungry")

  class Person(val name: String, age: Int)

  class Employee(override val name: String, age: Int, gender: String, designation: String, salary: Int) extends Person(name, age){
    def apply: String = s"Employee Name: $name, age: $age, gender: $gender, designation: $designation, salary: $salary"
  }

  class Manager(override val name: String, age: Int, gender: String, designation: String, salary: Int) extends Person(name, age){
    def apply: String = s"Manager Name: $name, age: $age, gender: $gender, designation: $designation, salary: $salary"
  }

  val emp = new Employee("Vinay", 27, "male", "Senior Software Engineer", 68000)
  val manager = new Manager("Shruti", 34, "female", "General Manager", 150000)

  println (emp.apply)
  println (manager.apply)

  //Polymorphism
  val huskie: Animal = new Dog
  println (huskie sounds)


  /*
  1. final class cannot be inherited by creating subclasses
  2. final method cannot be inherited
  3. sealed class cannot be inherited outside the current class
  * */
}
