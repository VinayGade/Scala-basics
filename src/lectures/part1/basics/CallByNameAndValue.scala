package lectures.part1.basics

object CallByNameAndValue extends App{

  def callByValue(time: Long) = {
    println("By Value")
    println("value1 ="+time)
    println("value2 ="+time)
  }

  def callByName(time: => Long) = {
    println("By Name")
    println("value1 ="+time)    // System.nanoTime()
    println("value2 ="+time)    // System.nanoTime()
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

}
