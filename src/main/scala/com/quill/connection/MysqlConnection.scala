package com.quill.connection

import io.getquill.{MysqlAsyncContext, SnakeCase}

trait MysqlConnection {

  lazy val ctx = new MysqlAsyncContext(SnakeCase, "ctx")

}
