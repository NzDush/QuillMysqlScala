package com.quill.models

import com.quill.connection.MysqlConnection

case class EmployeeProjects(employee_project_id: Int, employee_id: Int, project_id: Int)

trait EmployeeProjectsModel extends MysqlConnection{

  import ctx._

  val employeeProjectsTable = quote {
    querySchema[EmployeeProjects]("Employee_has_Project",
      _.employee_project_id -> "employee_project_id",
      _.employee_id -> "employee_id",
      _.project_id -> "project_id"
    )
  }

}
