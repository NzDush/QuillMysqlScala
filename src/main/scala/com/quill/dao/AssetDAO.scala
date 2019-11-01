package com.quill.dao

import com.quill.connection.MysqlConnection
import com.quill.models.{Asset, AssetModel, Employee, EmployeeModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait AssetDAO extends  //AbstractDAO[Asset] with
                        EmployeeModel with
                        AssetModel with
                        MysqlConnection {
  import ctx._

  def employeeAssetFilterSalary(lowerSalaryLimit: Double): Future[List[(Employee, Asset)]] ={
    val customQuery = quote{
      employeeTable.
        join(assetTable).
        on((employee, asset) => employee.id == asset.employee_id).
        filter(employeeAsset => employeeAsset._1.salary > lift(lowerSalaryLimit))
    }
    val str = ctx.translate(customQuery)
    println(str)

    val result = ctx.run(customQuery)
    result
  }

//    def insert(asset: List[Asset]): Future[List[Asset]] ={
//
//    }
//
//    def viewAll: Future[List[Asset]] ={
//
//    }
//
//    def update(asset_id: Int, newAsset: Asset): Future[Asset]={
//
//    }
//
//    def delete(asset_id: Int): Future[Int]={
//
//    }

}
