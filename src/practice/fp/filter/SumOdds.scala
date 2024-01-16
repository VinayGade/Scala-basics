package practice.fp.filter

object SumOdds extends App{

  def f(arr:List[Int]):Int = arr.filter(_%2!=0).sum
    arr.filterNot(_%2==0).sum
  val arr = List(2, 5, 3, 4, 6, 7, 9, 8)
  println(f(arr))
}
