package com.quill.dao

import com.quill.models.Employee
import scala.concurrent.Future

trait AbstractDAO[T] {

  def insert(row: List[T]): Future[List[T]]

  def viewAll: Future[List[T]]

  def update(id: Int, data: T): Future[T]

//  def delete(id: Int): Future[T]

}
