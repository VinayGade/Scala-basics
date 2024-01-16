package lectures.part3.functional.collections

object TuplesAndMap extends App{

  /*
  *  Tuples = Finite Ordered List
  *  Tuple2 [Int, String] = (Int, String)
  * */
  val tuple2 = Tuple2(2, "Scala 2.12")
  val tuple = (2, "Scala")

  println(tuple._1)
  println(tuple._2)

  val tuple3 = tuple.swap
  println(tuple.swap)
  println(tuple3)

  println(tuple.copy(_2 = "Goodbye Java8 and Welcome Scala 12"))

  //tuple3 = tuple3.swap// type mismatch error: required:(String, Int) found:(Int, String)

  val tuple4 = tuple.copy(_2 = "Goodbye Java8 and Welcome Scala 12")

  val tuple5 = tuple.copy()     //Copy as it is

  println(tuple.toString())
  println(tuple4)
  println(tuple5)

  /*
  Maps
  Map - key -> value
  Map - (key, value)
  a -> b is Syntactuc sugar for (a, b)
  */

  var phoneBook: Map[String, Int] = Map()
  phoneBook = Map(("Vinay", 42042), "Smita" -> 99287)
  println("phoneBook : " +phoneBook)

  println("PhoneBook contains : " + phoneBook.contains("Smita"))
  println("PhoneBook . apply (Vinay) : " + phoneBook("Vinay"))      //phoneBook.get(key)
  //println("PhoneBook . apply (Sapna) : " + phoneBook("Sapna"))      //NoSuchElementException

  val newPair = "Sapna" -> 98327
  val newPhoneBook = phoneBook + newPair

  println(newPhoneBook)

  //Functions on Map : map, flatMap, filter

  println("capital phonebook : " + newPhoneBook.map(pair => pair._1.toUpperCase() -> pair._2))

  //filter Keys
  println("names with S : " + newPhoneBook.filterKeys(x => x.startsWith("S")) )

  //Map Values
  println("New Phonebook Values : "+newPhoneBook.mapValues(n => n * 100))

  println("New Phonebook Values Prepend postal code : "+newPhoneBook.mapValues(n => "0251-" +  n ))

  val phoneBookList = newPhoneBook.toList

  val listToMap = phoneBookList.toMap

  println("Map to List : " + phoneBookList)
  println("List to Map : " + listToMap)

  val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
  println("Group By : "+ days.groupBy(x => x.charAt(0)))

  //** Widely used by Data Scientists in *Spark

  /*
  Exercises:
  1. What happen if ("Vinay" -> 1234) and ("VINAY" -> 5436) are there in map

  2. Social network based on maps
     - Add Person to network
     - remove Person from network
     - friend Person
     - unfriend Person
     - number of friend of Person
     - person with most friends
     - how many people have no friends
     - if two people are connected

  * */

  //
  val duplicatesMap = Map(("Vinay", 42042), "Smita" -> 99287, "Sapna" -> 98327, "VINAY" -> 94567)
  println(duplicatesMap.map(pair => pair._1.toUpperCase() -> pair._2))    // Overlapping duplicates

  //2
  //def add(network: Map[String, List[String]], person: String): Map[String, List[String]] =
  /*
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> List(String))

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    //network + (a -> (friendsA :+ b)) + (b -> (friendsB :+ a))
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux (friends: Set[String], networkAux: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAux
      else removeAux(friends.tail, unfriend(networkAux, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }
   */

}
