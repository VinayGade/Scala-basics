package practice.collections.tuple_map

object MapDemo extends App{

  import scala.collection.mutable.Map
  val treasureMap = Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))
  println()


  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumeral(4))

}
