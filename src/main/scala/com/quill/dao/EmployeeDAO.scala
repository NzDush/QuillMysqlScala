package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{Employee, EmployeeModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait EmployeeDAO extends AbstractDAO[Employee] with
                          EmployeeModel with
                          MysqlConnection {
  import ctx._

  def insert(employees: List[Employee]): Future[List[Employee]] = {
    val insertEmployees = quote {
      liftQuery(employees).foreach(t => employeeTable.insert(t))
    }
    val str: List[String] = ctx.translate(insertEmployees)
    str.map(println)

    val result = ctx.run(insertEmployees).map(_ => employees)
    result
  }

  def viewAll: Future[List[Employee]] ={
    val viewAllEmployees = quote{
      employeeTable
    }
    val str = ctx.translate(viewAllEmployees)
    println(str)

    val result = ctx.run(viewAllEmployees)
    result
  }

  def update(employee_id: Int, newEmployee: Employee): Future[Employee] ={
    val updateEmployee = quote{
      employeeTable.filter(employee => employee.id == lift(employee_id)).
        update( employee => employee.name -> lift(newEmployee.name),
                employee => employee.address -> lift(newEmployee.address),
                employee => employee.salary -> lift(newEmployee.salary))
    }
    val str = ctx.translate(updateEmployee)
    println(str)

    val result = ctx.run(updateEmployee).map(_ => newEmployee)
    result
  }

  def delete(employee_id: Int): Future[Int] ={
    val deleteEmployee = quote{
      employeeTable.filter(employee => employee.id == lift(employee_id)).delete
    }
    val str = ctx.translate(deleteEmployee)
    println(str)

    val result = ctx.run(deleteEmployee).map(_ => employee_id)
    result
  }

}
