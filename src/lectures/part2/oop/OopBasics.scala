package lectures.part2.oop

object OopBasics extends App{

  val person = new Person
  val employee = new Employee("Vinay", 28, "Engineer")
  println(employee.age)
  println(employee.greet("Vinay"))
  println(employee greet "Vinay")
  println(employee.greet)

  def +(s1: String, s2: String): String = s1 concat s2

}

class Person

class Employee( val name: String, val age: Int, designation: String){    //Constructor

  //without val for age it cannot be acessed  like employee.age
  def greet(name: String): Unit = println("Hello :"+this.name)  //this.name == name

  //Overloading constructor
  def greet(): Unit = println(s"Hi! I am $name")

}