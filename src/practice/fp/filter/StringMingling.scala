package practice.fp.filter

import scala.io.StdIn

object StringMingling extends App{
  val P: String = StdIn.readLine()
  val Q: String = StdIn.readLine()
  val N: Int = P.length
  val R: String = mingle(P,Q,N)
  println(R)

  def mingle(p: String, q: String, n:Int): String = {
    var r = ""
    var i = 0
    while (i < n){
      r = r.concat(p.substring(i,i+1))
      r = r.concat(q.substring(i,i+1))
      i += 1
    }
    r
  }
}
