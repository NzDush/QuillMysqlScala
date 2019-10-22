package com.quill.main

import com.quill.components.IOUtil
import com.quill.models.Employee
import scala.concurrent.ExecutionContext.Implicits.global //need for onComplete{} method

object Main extends App with IOUtil {

  import com.quill.dao.EmployeeDAO._

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  insert(List(Employee(8, "aaa", "Panadura", Some(10)), Employee(7, "bbb", "Kalutara", Some(10))))

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = viewAll
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  update(4, Employee(4, "JKL", "Jaffna", Some(31)))

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  delete(7)

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = employeesAssetFilterSalary(50)
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  val result = employeeProjects
  result.onComplete{
    case result =>  printList(result.get)
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  System.in.read();



}