package com.quill.controller

import com.quill.dao.ManufacturerDAO
import com.quill.models.{Assets, Employee, EmployeeProjects, Manufacturer, Project}
import scala.concurrent.Future

object ManufacturerController extends ManufacturerDAO{

  def connectionBetweenEmployeeAssetManufacturer: Future[List[((Employee, Assets), Manufacturer)]] ={
    val result = employeeAssetManufacturer
    result
  }

  def connectionBetweenProjectEmployeeAssetManufacturer: Future[List[((((Project, EmployeeProjects), Employee), Assets), Manufacturer)]] ={
    val result = projectEmployeeAssetManufacturer
    result
  }

}
