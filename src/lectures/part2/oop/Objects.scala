package lectures.part2.oop

object Objects{

  // Scala doesn't have static

  object Bird {
    val N_LEGS = 2

    def canFly: Boolean = true

    //factory method: Default factory method is apply
    def apply(name: String, family: String): String = s"Bird $name belongs to $family Order of birds."
  }

  class Bird(val name: String, flyHeight: Int) {

  }

  //object Bird and class Bird are COMPANIONS

  def main(args: Array[String]): Unit = {
    println(Bird.N_LEGS)
    println(Bird canFly)

    val duck = Bird
    val eagle = Bird

    val siberianCrane = new Bird("Siberian crane", 12000)

    println(duck == eagle)

    println(siberianCrane == duck)

    println(Bird("Hen", "Galliformes"))

    /* ***** Scala Applications ******

  def main(args: Array[String]): Unit = {

  }

  remove extends App
  from object definition signature

  Execution corresponds to psvm(String[] args) of Java
   */


  }
}