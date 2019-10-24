package com.quill.controller

import com.quill.dao.AssetDAO
import com.quill.models.{Asset, Employee}
import scala.concurrent.Future

object AssetController extends AssetDAO{

  def employeeAssetsWithFilterSalary(lowerSalaryLimit: Double): Future[List[(Employee, Asset)]] ={
    val result = employeeAssetFilterSalary(lowerSalaryLimit)
    result
  }

}
