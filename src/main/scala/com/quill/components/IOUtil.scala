package com.quill.components

trait IOUtil {

  def printList(args: List[_]): Unit = {
    args.foreach(println)
  }

}
