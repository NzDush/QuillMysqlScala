package com.quill.models

import com.quill.components.EmployeeComponent.ctx

case class Employee(id: Int, name: String, address: String, salary: Option[Double])

trait EmployeeModel {

  import ctx._

  val employeeTable = quote {
    querySchema[Employee]("Employee", _.id -> "employee_id", _.name -> "name", _.address -> "address", _.salary -> "salary")
  }

}
