package com.quill.models

import com.quill.connection.MysqlConnection

case class Manufacturer(id: Int, name: String, country: String)

trait ManufacturerModel extends MysqlConnection{

  import ctx._

  val manufacturerTable = quote {
    querySchema[Manufacturer]("Manufacturer",
      _.id -> "manufacturer_id",
      _.name -> "name",
      _.country -> "country"
    )
  }

}
