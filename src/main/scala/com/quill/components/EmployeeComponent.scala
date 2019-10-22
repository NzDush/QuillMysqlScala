//package com.quill.components
//
//import com.quill.connection.MysqlConnection
//import com.quill.dao.EmployeeDAO
//import com.quill.models.{Employee, EmployeeModel}
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.Future
//
//object EmployeeComponent extends MysqlConnection with EmployeeModel {
//  import ctx._
//
////  def create: Unit ={
////
////  }
//  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  def insert(employees: List[Employee]): Future[List[Employee]] = {
//
//    val str: List[String] = ctx.translate(insertEmployees)
//    str.map(println)
//
//    val result = ctx.run(insertEmployees).map(_ => employees)
//    result
//  }
//  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  def viewAll: Future[List[Employee]] ={
//    val viewAllEmployees = quote{
//      employeeTable
//    }
//    val str = ctx.translate(viewAllEmployees)
//    println(str)
//
//    val result = ctx.run(viewAllEmployees)
//    result
//  }
//  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  def update(employee_id: Int, newEmployee: Employee): Future[Employee] ={
//    val updateEmployee = quote{
//      employeeTable.filter(employee => employee.id == lift(employee_id)).update(employee => employee.name -> lift(newEmployee.name),
//                                                                                employee => employee.address -> lift(newEmployee.address),
//                                                                                employee => employee.salary -> lift(newEmployee.salary))
//    }
//    val str = ctx.translate(updateEmployee)
//    println(str)
//
//    val result = ctx.run(updateEmployee).map(_ => newEmployee)
//    result
//  }
//  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  def delete(employee_id: Int): Future[Employee.type] ={
//    val deleteEmployee = quote{
//      employeeTable.filter(employee => employee.id == lift(employee_id)).delete
//    }
//    val str = ctx.translate(deleteEmployee)
//    println(str)
//
//    val result = ctx.run(deleteEmployee).map(_ => Employee)
//    result
//  }
//
//}