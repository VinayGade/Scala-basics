package lectures.part1.basics

object StringOperations extends App{

  val line = "Functional Programming with Scala 2.12"

  //charAt subString toLowerCase  length replace split startsWith endsWith
  println(line.substring(11))
  println(line.substring(11,22))
  println(line.length)
  println(line.charAt(34))
  println(line.toLowerCase)
  println(line.split(" ").toList)
  println(line.replace(" ","-"))
  println(line.startsWith("Functional"))
  println(line.endsWith("12"))
  println(line.take(2))
  println(line.reverse)

  var vowels = "eio"
  println(vowels)

  vowels = ("a"+: vowels :+ 'u').mkString
  println(vowels)

  val person = new Person()
  val name = person.getName
  val age = person.getAge
  val address = person.getAddress

  println(s"Person name: $name age: ${age+2} address: $address")

  class Person(age: Int=25, name: String="Vinay", address: String="Dombivali") {
    def getName: String = name
    def getAge: Int = age
    def getAddress: String = address
  }

  val PI = 3.1416f
  def area = 10 * 10 * PI
  println(f"area of circle with radius = 10 is $area%3.2f")

}