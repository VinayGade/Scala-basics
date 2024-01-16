package lectures.part1.basics

object Expressions extends App{
    var x = 1+2 //Expression
    println(x)
    x += 1
    println(x)

    val even = if(x%2==0) "Even" else "Odd" //Expression
    println("x is " + even)

    val weird = (x = 5)  //Unit = Void
    println(weird)

    //Code Block ... value = value ( last expression )
    //Use if Code Block doesn't take any input parameters
    val areablock = {
        val r = 10
        val PI = 3.1416
        PI * r * r
    }

    println("Area of Circle with radius 10 : "+areablock)

    //Note : Never use loops in Scala, use expressions and recursive methods instead.
}
