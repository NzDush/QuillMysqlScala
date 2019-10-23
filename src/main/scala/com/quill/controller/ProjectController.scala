package com.quill.controller

import com.quill.dao.ProjectDAO
import com.quill.models.{Employee, EmployeeProjects, Project}
import scala.concurrent.Future

object ProjectController extends ProjectDAO{

  def employeeWithProjects: Future[List[((Employee, EmployeeProjects), Project)]] ={
    val result = employeeProjects
    result
  }

}
