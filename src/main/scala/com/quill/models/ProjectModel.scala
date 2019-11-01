package com.quill.models

import java.util.Date
import com.quill.connection.MysqlConnection

case class Project(id: Int, name: String, start: Option[Date], end: Option[Date])

case class Project_True(project_id: Int, name: String, start: Option[Date], end: Option[Date])

case class Project_Partial(project_id: Int, name: String)

trait ProjectModel extends MysqlConnection{

  import ctx._

  val projectTable = quote {
    querySchema[Project]("Project",
      _.id -> "project_id",
      _.name -> "name",
      _.start -> "start",
      _.end -> "end"
    )
  }

}
