package com.quill.controller

import com.quill.dao.ProjectDAO
import com.quill.models.{Employee, EmployeeProjects, Project, Project_Partial, Project_True}
import scala.concurrent.Future

object ProjectController extends ProjectDAO{

  def employeeWithProjects: Future[List[((Employee, EmployeeProjects), Project)]] ={
    val result = employeeProjects
    result
  }

  def viewProjectsFromRawSql: Future[List[Project_True]] ={
    val result = getProjectsFromSql
    result
  }

  def viewProjectNamesFromRawSql: Future[List[Project_Partial]] ={
    val result = getProjectNamesFromSql
    result
  }

}
