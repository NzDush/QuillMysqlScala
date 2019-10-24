package com.quill.main

import com.quill.components.IOComponent
import com.quill.models.Employee
import com.quill.controller.EmployeeController.{insertEmployee, viewAllEmployees, updateEmployeeViaId, deleteEmployeeViaId, groupEmployeesByAddress, sortEmployeeBySalary}
import com.quill.controller.AssetController.employeeAssetsWithFilterSalary
import com.quill.controller.ProjectController.employeeWithProjects
import com.quill.controller.ManufacturerController.{connectionBetweenEmployeeAssetManufacturer, connectionBetweenProjectEmployeeAssetManufacturer}
import scala.concurrent.ExecutionContext.Implicits.global //need for onComplete{} method

object Main extends App with IOComponent {
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  insertEmployee(List(Employee(30, "aaa", "Panadura", 10), Employee(31, "bbb", "Kalutara", 10)))

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = viewAllEmployees
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  updateEmployeeViaId(31, Employee(4, "JKL", "Jaffna", 31.5))

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  deleteEmployeeViaId(30)

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = employeeAssetsWithFilterSalary(50)
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = employeeWithProjects
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = connectionBetweenEmployeeAssetManufacturer
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  val result = connectionBetweenProjectEmployeeAssetManufacturer
  result.onComplete{
    case result =>  printList(result.get)
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = groupEmployeesByAddress
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//  val result = sortEmployeeBySalary
//  result.onComplete{
//    case result =>  printList(result.get)
//  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  System.in.read()

}