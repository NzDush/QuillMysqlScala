package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{Assets, AssetModel, Employee, EmployeeModel, EmployeeProjects, EmployeeProjectsModel, Manufacturer, ManufacturerModel, Project, ProjectModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ManufacturerDAO extends //AbstractDAO[Employee] with
                              EmployeeModel with
                              EmployeeProjectsModel with
                              ProjectModel with
                              AssetModel with
                              ManufacturerModel with
                              MysqlConnection {
  import ctx._

  def employeeAssetManufacturer: Future[List[((Employee, Assets), Manufacturer)]] ={
    val customQuery = quote{
      employeeTable.
        join(assetTable).
          on((employee, asset) => employee.id == asset.employee_id).
        join(manufacturerTable).
          on((employee_asset, manufacturer) => employee_asset._2.manufacturer_id == manufacturer.id)
    }
    val str = ctx.translate(customQuery)
    println(str)

    val result = ctx.run(customQuery)
    result
  }

  def projectEmployeeAssetManufacturer: Future[List[((((Project, EmployeeProjects), Employee), Assets), Manufacturer)]] ={
    val customQuery = quote{
      projectTable.
        join(employeeProjectsTable).
          on((project, employeeHasProject) => project.id == employeeHasProject.project_id).
        join(employeeTable).
          on((project_employeeHasProject, employee) => project_employeeHasProject._2.employee_id == employee.id).
        join(assetTable).
          on((project_employeeHasProject_employee, asset) => project_employeeHasProject_employee._2.id == asset.employee_id).
        join(manufacturerTable).
          on((project_employeeHasProject_employee_asset, manufacturer) => project_employeeHasProject_employee_asset._2.manufacturer_id == manufacturer.id)
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
