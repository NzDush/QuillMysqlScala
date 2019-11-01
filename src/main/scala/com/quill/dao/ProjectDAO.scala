package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{Employee, EmployeeModel, EmployeeProjects, EmployeeProjectsModel, Project, ProjectModel, Project_Partial, Project_True}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProjectDAO extends  //AbstractDAO[Project] with
                          EmployeeModel with
                          ProjectModel with
                          EmployeeProjectsModel with
                          MysqlConnection {
  import ctx._

  def employeeProjects: Future[List[((Employee, EmployeeProjects), Project)]] ={
    val customQuery = quote{
      employeeTable.
        join(employeeProjectsTable).
          on((employee, employeeHasProject) => employee.id == employeeHasProject.employee_id).
        join(projectTable).
          on((employee_employeeHasProject, project) => employee_employeeHasProject._2.project_id == project.id).sortBy(employee => employee._1._2.project_id)
    }
    val str = ctx.translate(customQuery)
    println(str)

    val result = ctx.run(customQuery)
    result
  }

  def getProjectsFromSql: Future[List[Project_True]] ={
    val rawQuery = quote(
      infix"""SELECT * FROM Project""".as[Query[Project_True]]
    )
    val str = ctx.translate(rawQuery)
    println(str)

    val result = ctx.run(rawQuery)
    result
  }

  def getProjectNamesFromSql: Future[List[Project_Partial]] ={
    val rawQuery = quote(
        infix"""SELECT project_id, name FROM Project""".as[Query[Project_Partial]]
    )
    val str = ctx.translate(rawQuery)
    println(str)

    val result = ctx.run(rawQuery)
    result
  }

  //  def insert(project: List[Project]): Future[List[Project]] ={
  //
  //  }
  //
  //  def viewAll: Future[List[Project]] ={
  //
  //  }
  //
  //  def update(project_id: Int, newProject: Project): Future[Project]={
  //
  //  }
  //
  //  def delete(project_id: Int): Future[Int]={
  //
  //  }

}
