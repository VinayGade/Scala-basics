package lectures.part3.functional

object FoldDemo extends App {

  /*
  *
  * Eg. 1: Convert Map[Int, Person] into List[Person]
  * */
  case class Person(name: String, age: Int)

  //Define Users map
  val users: Map[Int, Person] =
    Map(1 -> Person("Tom", 10), 2 -> Person("Gillian", 13), 3 -> Person("Sarah", 17), 4 -> Person("David", 20))

  val peopleList: List[Person] = users.foldLeft(List.empty[Person])((people, current) => {
    people :+ current._2
  })

  peopleList.foreach(println)

}