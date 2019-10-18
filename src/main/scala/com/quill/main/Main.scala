package com.quill.main

import com.quill.components.IOUtil
import com.quill.models.Employee
import scala.concurrent.ExecutionContext.Implicits.global //need for onComplete{} method

object Main extends App with IOUtil {

  import com.quill.components.EmployeeComponent._

  insert(List(Employee(6, "aaa", "Panadura", Some(10)), Employee(7, "bbb", "Kalutara", Some(10))))

  ///////////////////

  System.in.read();

}