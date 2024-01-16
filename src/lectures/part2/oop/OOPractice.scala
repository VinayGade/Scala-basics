package lectures.part2.oop

object OOPractice extends App {

  /*
  Writer : fname, lname, age
  - fullName()

  Novel : Name, year, Author
  - authorAge()
  - isWrittenBy (author)
  - copy (new year of release ) = new instance of novel
   */

  class Writer(fname: String, lname: String, val year: Int) {   // year : field   fname, lname : parameters
    def fullName: String = fname + " " + lname
    override def toString: String =" fname : "+ fname + " lname: " + lname + " year: " + year
  }

  class Novel(name: String, year: Int, author: Writer) {
    def authorAge: Int = year - author.year
    def isWrittenBy(author: Writer): Boolean = author == this.author
    def copy(newyear: Int): Novel = new Novel(name, newyear, author)
    override def toString: String = "name: "+ name + " year: "+ year + "author :"+ author.toString
  }

  val author1 = new Writer("Dan", "Brown", 1965)
  val author2 = new Writer("George", "Martin", 1952)

  val novel1 = new Novel("Game of Thrones", 1972, author2)
  val novel2 = new Novel("Da Vinci Code", 2001, author1)
  val novel3 = new Novel("Digital Fortress", 1998, author1)
  val novel4 = new Novel("The Deception Point", 2003, author1)
  val novel5 = new Novel("Inferno", 2010, author1)
  val novel6 = new Novel("Song of Ice And Fire", 1992, author2)

  println(novel1)
  println(novel2)
  println(novel3)
  println(novel4)
  println(novel5)
  println(novel6)

  class Counter(val count:Int) {
    def inc = new Counter(count+1)   //immutable counter
    def dec = new Counter(count-1)

    def incn(n: Int) = new Counter(count + n)
    def decn(n: Int) = new Counter(count - n)

    def print = println(count)
  }

  val counter = new Counter(10)
  println("counter + 1 = "+counter.inc.print)
  println("counter - 1 = "+counter.dec.print)

  println("step = 5")
  println("counter + 5 = "+counter.incn(5).print)
  println("counter - 5 = "+counter.decn(5).print)

}