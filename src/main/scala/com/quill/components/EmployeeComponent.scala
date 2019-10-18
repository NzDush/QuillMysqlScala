package com.quill.components

import com.quill.connection.MysqlConnection
import com.quill.models.{Employee, EmployeeModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object EmployeeComponent extends MysqlConnection with EmployeeModel {
  import ctx._

//  def create: Unit ={
//
//  }

  def insert(employees: List[Employee]): Future[List[Employee]] = {
    val insert = quote {
      liftQuery(employees).foreach(t => acc.insert(t))
    }
//    val str: List[String] = ctx.translate(insert)
//    str.map(println)

    ctx.run(insert).map(_ => employees)
  }

//  def view: Unit ={
//
//  }

//  def delete: Unit ={
//
//  }

}