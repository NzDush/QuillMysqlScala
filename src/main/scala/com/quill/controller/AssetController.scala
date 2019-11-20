package com.quill.controller

import com.quill.dao.AssetDAO
import com.quill.models.{Assets, Employee}
import scala.concurrent.Future

object AssetController extends AssetDAO{

  def employeeAssetsWithFilterSalary(lowerSalaryLimit: Double): Future[List[(Employee, Assets)]] ={
    val result = employeeAssetFilterSalary(lowerSalaryLimit)
    result
  }

}
