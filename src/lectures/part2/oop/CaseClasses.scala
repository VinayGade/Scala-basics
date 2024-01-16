package lectures.part2.oop

object CaseClasses extends App{

  //equals hashcode tostring

  case class Person(name: String, age: Int)

  val tom = new Person("Tom",25)
  println(tom.age)
  println(tom.toString)
  println(tom)

  val tom2 = Person("Tom", 30)     // "new" is optional
  val tom3 = Person("Tom", 25)

  println(tom == tom2)
  println(tom == tom3)

  val tom4 = tom2.copy()
  val tom5 = tom3.copy(age = 35)
  println(tom4)
  println(tom5)

  /*
  Case class are companion objects.
  * */

  val thePerson = Person
  val mary = Person("Mary", 23)

  // case classes are serializable   ...Serializable used in Akka

  // case classes have Extractor Pattern and widely used in pattern matching

  case object UnitedKingdom {
    def name: String = "Britain Scotland Ireland"
  }

}
