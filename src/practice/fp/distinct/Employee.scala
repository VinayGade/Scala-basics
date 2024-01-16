package practice.fp.distinct

class Employee( val id: Int, val name: String, val age: Int, val designation: String){

  override def toString: String = s"($id, $name, $age, $designation)"

  override def equals(e: Any): Boolean = {
    e match {
      case e: Employee => {
          this.id == e.id ||
          this.name.equals(e.name) ||
          super.equals(e)
      }
      case _ => false
    }
  }
}