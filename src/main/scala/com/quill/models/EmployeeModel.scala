package com.quill.models

import com.quill.connection.MysqlConnection

case class Employee(id: Int, name: String, address: String, salary: Double)

trait EmployeeModel extends MysqlConnection{

  import ctx._

  val employeeTable = quote {
    querySchema[Employee]("Employee",
      _.id -> "employee_id",
      _.name -> "name",
      _.address -> "address",
      _.salary -> "salary"
    )
  }

}
