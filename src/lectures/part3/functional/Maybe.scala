package lectures.part3.functional

abstract class Maybe[+T] {

  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]

  /**
   1. map with type parameter B, a function f that takes T and Returns B : map returns Maybe[B]
   2. flatMap with type parameter B, a function f that takes T and Returns Maybe[B]: flatMap returns Maybe[B]
   3. filter recieves a predicate, that applied over T and returns T
   */

}

case object MaybeNot extends Maybe[Nothing]{
  override def map[B](f: Nothing => B): Maybe[B] = MaybeNot

  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot

  override def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T]{
  override def map[B](f: T => B): Maybe[B] = Just(f(value))

  override def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

  override def filter(p: T => Boolean): Maybe[T] = if(p(value)) this else MaybeNot
}

object MaybeTest extends App{
  val just = Just(3)
  println(just)
  println(just.map(_*2))
  println(just.flatMap(x => Just(x % 2 == 0)))
  println(just.filter(_ % 2 == 0))
}