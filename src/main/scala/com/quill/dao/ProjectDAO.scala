package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{AssetModel, Employee, EmployeeModel, EmployeeProjects, EmployeeProjectsModel, Project, ProjectModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProjectDAO extends  //AbstractDAO[Project] with
                          EmployeeModel with
                          AssetModel with
                          ProjectModel with
                          EmployeeProjectsModel with
                          MysqlConnection {
  import ctx._

  def employeeProjects: Future[List[((Option[Employee], EmployeeProjects), Option[Project])]] ={
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
