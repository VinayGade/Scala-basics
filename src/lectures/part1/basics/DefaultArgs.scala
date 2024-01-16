package lectures.part1.basics

object DefaultArgs extends App{

  def factorialWithDefault(n: Int, accumulator: Int = 1): Long = {
    if(n<=1) accumulator
    else factorialWithDefault(n-1, n * accumulator)
  }

  println("factorial = "+factorialWithDefault(10))

  def savePicture(format: String = "png", width: Int = 520, height: Int = 380): Unit = {
    println("format= " + format + ", width= " + width + ", height= " + height)
  }

  println("Saving picture")
  savePicture()
  savePicture(format = "jpg")
  savePicture(width = 720)
  savePicture(width = 1260, height = 720, format = "jpg")

}
