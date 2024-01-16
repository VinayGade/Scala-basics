package practice.fp.distinct

object ListUtil {
  def dedupe[T](elements:List[T]):List[T] = elements match {
    case Nil => elements
    case head::tail => head :: dedupe(tail filterNot (_==head))
  }


}
