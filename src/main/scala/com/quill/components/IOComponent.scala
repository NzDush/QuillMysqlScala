package com.quill.components

trait IOComponent {

  def printList(args: List[_]): Unit = {
    args.foreach(println)
  }

}
