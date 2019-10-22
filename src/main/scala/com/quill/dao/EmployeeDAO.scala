package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{Asset, AssetModel, Employee, EmployeeModel, EmployeeProjects, EmployeeProjectsModel, Project, ProjectModel}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object EmployeeDAO extends  AbstractDAO[Employee] with
                            EmployeeModel with
                            AssetModel with
                            ProjectModel with
                            EmployeeProjectsModel with
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

  def delete(employee_id: Int): Future[Employee] ={
    val deleteEmployee = quote{
      employeeTable.filter(employee => employee.id == lift(employee_id)).delete
    }
    val str = ctx.translate(deleteEmployee)
    println(str)

    val result = ctx.run(deleteEmployee).map(_ => Employee)
    result
  }

  def employeesAssetFilterSalary(lowerSalaryLimit: Double): Future[List[(Employee, Option[Asset])]] ={
    val customQuery = quote{
      employeeTable.
        leftJoin(assetTable).
          on((employee, asset) => employee.id == asset.employee_id).
        filter(employeeAsset => employeeAsset._1.salary > lift(lowerSalaryLimit))
    }
    val str = ctx.translate(customQuery)
    println(str)

    val result = ctx.run(customQuery)
    result
  }

  def employeeProjects:Future[List[((Option[Employee], EmployeeProjects), Option[Project])]]={
    val customQuery = quote{
      employeeTable.
        rightJoin(employeeProjectsTable).
          on((employee, employee_project) => employee.id == employee_project.employee_id).
        leftJoin(projectTable).
          on((employee_project, project) => employee_project._2.project_id == project.id).sortBy(employee => employee._1._2.project_id)
    }
    val str = ctx.translate(customQuery)
    println(str)

    val result = ctx.run(customQuery)
    result
  }


}
