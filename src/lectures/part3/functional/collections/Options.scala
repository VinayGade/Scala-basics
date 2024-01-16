package lectures.part3.functional.collections

object Options extends App{

  val firstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(firstOption)

  // Work with Unsafe API
  def unsafeMethod: String = null
  val result = Option(unsafeMethod)   //Some or None
  println(result)

  //Chanied methods
  def backupMethod : String = "Some Valid result"
  val chainedResult = Option(unsafeMethod).orElse(Option(backupMethod))

  //Design Unsafe API
  def betterUnsafeMethod : Option[String] = None
  def betterBackupMethod : Option[String] = Some("A Valid String")

  val betterChainedMethod : Option[String] = betterUnsafeMethod orElse betterBackupMethod
  println(firstOption.isEmpty)
}
