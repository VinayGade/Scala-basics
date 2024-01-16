package lectures.part3.functional

import scala.collection.mutable.ListBuffer

object HOFCurries extends App{

  /*
  Higher order functions ::
  map, filter, flatMap
  */

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plus1 = (x: Int) => x+1

  println("nTimes Plus1 = "+nTimes(plus1, 10, 1))     //function as parameter

  // Better solution
  def nTimesPlus1(f: Int => Int, n: Int) : (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesPlus1(f, n - 1)(f(x))

  val plus10 = nTimesPlus1(plus1, 10)
  println("nTimes Plus1 Better =" + plus10(1))

  // ** This is NOT EASY ... Recursion with function as argument...

  // ** Curried function **

  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  val add3 = superAdder(3)
  println("add 3 with 10 = "+ add3(10))
  println("3 + 10 = "+ superAdder(3)(10))

  def add2(a: Int) = (b: Int) => a + b
  val sum2 = add2(29)
  println(sum2(5))

  def add4(a: Int) (b: Int) = a + b;
  val sum4 = add4(30)_
  println(sum4(5))


  /*
   zipWith

   [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4, 10, 18]
  *
  * */
  val list = List(1, 2, 3)

 // val zippedMulti = list.zipWith(x => )

  /*
  fold

  fold(start)(function) => value

  [1,2,3].fold(0)(x + y) = 6
  * */

  /*
  compose(f, g) => x => f(g(x))
  inverse(g, g) => x => g(f(x))
  *
  * */

  /*
  Reverse Sort
  [100, 90, 10, 40, 20, 30]
  [10, 20, 30, 40, 90, 100]   ...Sorted
  [100, 90, 40, 30, 20, 10]   ...Reverse Sorted (y - x)
  * */

  val unsortedList = List(100, 90, 10, 40, 20, 30)
  val sorted = unsortedList.sorted

  println("Sorted List : " + sorted)
  val reverseOrder = sorted.reverse
  println("Reverse List : "+ reverseOrder)

  val listBuffer = new ListBuffer[Int]()
  listBuffer ++= unsortedList

  val sortedListBuffer = listBuffer.sorted

  println("Unordered ListBuffer"+listBuffer)
  println("Sorted ListBuffer"+sortedListBuffer)
  println("Reverse ListBuffer"+sortedListBuffer.reverse)

  /* Filter position in a list */
  /*
  For a given list with N integers, return a new list removing the elements at odd positions.
  The input and output portions will be handled automatically. You need to write a function with the recommended method signature.
  * */

  def f(arr:List[Int]):List[Int] = arr.zipWithIndex.filter(_._2 % 2 != 0).map(_._1)

  println(f(List(10,20,30,40,50,60,70,80,90)))

  /*
  List Replication
  * */
  /*
  3
1
2
3
4
  * */
  /*
  Output:
1
1
1
2
2
2
3
3
3
4
4
4
   */
  def f1(num:Int,arr:List[Int]):List[Int] = arr.flatMap(List.fill(num)(_))

}
