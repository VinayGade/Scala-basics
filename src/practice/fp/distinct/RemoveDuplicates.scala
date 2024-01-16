package practice.fp.distinct
//import java.util.Arrays

import ListUtil._

import scala.collection.mutable._
//import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.reflect.internal.util.Collections

object RemoveDuplicates extends App{

  println( dedupe(List("one","two","one")) )  // List(one, two)
  println( dedupe(List(1,2,3,4,5,2,3,6,1,1)) ) // List(1, 2, 3, 4, 5, 6)

  println("*** Employee Operations ***\n")

  val employeeList = new ListBuffer[Employee]()
  employeeList += new Employee(10, "Vinay", 27, "SE")
  employeeList += new Employee(20, "Shreya", 32, "DS")
  employeeList += new Employee(30, "Smita", 34, "DE")
  employeeList += new Employee(40, "Shilpa", 35, "TL")
  employeeList += new Employee(50, "Shruti", 35, "PO")
  employeeList += new Employee(70, "Shweta", 29, "SSE")
  employeeList += new Employee(80, "Sanyogita", 27, "SE")
  employeeList += new Employee(90, "Prachi", 25, "SE")
  employeeList += new Employee(60, "Kalpana", 26, "SE")
  employeeList += new Employee(100, "Ketan", 27, "SE")

  employeeList += new Employee(20, "Ali", 33, "TL")
  employeeList += new Employee(40, "Tushar", 27, "SE")
  employeeList += new Employee(70, "Ankit", 27, "HR")
  employeeList += new Employee(60, "Monica", 38, "HRM")

  employeeList.foreach(println(_))
  println(employeeList.size)

  println("\n *** Employee Distinct Set ***\n")

  /*
  //type 1
  val employeeDistinct: LinkedHashSet[Any] = new LinkedHashSet[Any]()
  employeeList.removeIf(e => !employeeDistinct.add(Arrays.asList(e.id, e.name)))

  employeeDistinct.foreach(println(_))
  println(employeeDistinct.size)

   */

  //list.map(function).distinct
  /*
  //type 2
  val employees: List[Employee] = employeeList.distinct.toSet.toList
  employees.foreach(println(_))
  println(employees.size)

   */
  //val employees = employeeList.distinct.toSet
  /*val employees1 : List[Employee] =
    employeeList.stream().distinct().

   */
  /*
  Set<String> nameSet = new HashSet<>();
  List<Employee> employeesDistinctByName = employees.stream()
            .filter(e -> nameSet.add(e.getName()))
            .collect(Collectors.toList());
  * */

  val employeeIdSet: Set[Int] = new mutable.HashSet[Int]()
  val distinctEmployeeById :ListBuffer[Employee] =  employeeList.filter(e => employeeIdSet.add(e.id))
  
  println("\n*** distinctEmployeeById ***")
  distinctEmployeeById.foreach(println(_))
  println(distinctEmployeeById.size)



  println( "\n$ $ $ $ $  UNIQUE $ $ $ $ $")
  val uniqueEmpList : List[Employee] = Collections.distinctBy(employeeList.toList)(_.id).distinct
  uniqueEmpList.foreach(println(_))
  println(uniqueEmpList.size)

  println( "\n$ $ $ $ $")
  val emps = employeeList.map(_.id).distinct.toList
  emps.foreach(println(_))
  println(emps.size)
}
