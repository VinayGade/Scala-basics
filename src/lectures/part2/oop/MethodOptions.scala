package lectures.part2.oop

object MethodOptions extends App{

  class Person(val name: String, favoriteMovie: String){
    def like(movie: String): Boolean = favoriteMovie.equals(movie)
    def hangouts(person: Person): String = s"${this.name} hangouts with ${person.name}"

    def apply(): String = s"${this.name} likes Da Vinci Code"
    def apply(movie: String): String = s"${this.name} likes ${movie} the most"
  }

  val vinay = new Person("Vinay", "The Dark Knight Rises")
  println(vinay.like("The Dark Knight Rises"))
  println(vinay like "The Dark Knight Rises")  // infix notation = opoerator notation = Syntactic Sugar

  //Only works with single parameter method

  val shruti = new Person("Shruti", "Inception")

  println(shruti hangouts vinay)

  val x = -1
  val y = 1.unary_-
  println(y)
  println(x.unary_-)

  def z = 2 == 3
  println(z.unary_!)

  //Only works with + - ! ~

  //apply
  println(vinay.apply())
  println(vinay())   // equivalent

  println(vinay apply)

  println(vinay.apply("Skyfall"))
  println(vinay apply "The Dark Knight")
  println(vinay("Pacific Rim"))

}
