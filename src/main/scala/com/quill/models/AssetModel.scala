package com.quill.models

import com.quill.connection.MysqlConnection

case class Asset(asset_id: Int, name: String, value: Option[Double], employee_id: Int, manufacturer_id: Int)

trait AssetModel extends MysqlConnection{

  import ctx._

  val assetTable = quote {
    querySchema[Asset]("Asset",
      _.asset_id -> "asset_id",
      _.name -> "name",
      _.value -> "asset_value",
      _.employee_id -> "employee_id",
      _.manufacturer_id -> "manufacturer_id"
    )
  }

}
