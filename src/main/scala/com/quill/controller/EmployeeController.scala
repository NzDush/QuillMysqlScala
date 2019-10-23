package com.quill.controller

import com.quill.dao.EmployeeDAO
import com.quill.models.{Asset, Employee, EmployeeProjects, Project}
import scala.concurrent.Future

object EmployeeController extends EmployeeDAO{

  def insertEmployee(employees: List[Employee]): Future[List[Employee]] ={
    val result = insert(employees)
    result
  }

  def viewAllEmployees: Future[List[Employee]] ={
    val result = viewAll
    result
  }

  def updateEmployeeViaId(employee_id: Int, newEmployee: Employee): Future[Employee] ={
    val result = update(employee_id, newEmployee)
    result
  }

  def deleteEmployeeViaId(employee_id: Int): Future[Int] ={
    val result = delete(employee_id)
    result
  }

}