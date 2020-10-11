package ch.danirey.givens.scala2

import ch.danirey.givens.Show

trait Show[A] {
  def show(a: A): String
}

object Show {
  implicit class ShowOps[A: Show](a: A) {
    def show = implicitly[Show[A]].show(a)
  }

  //type class instances
  implicit val intCanShow: Show[Int] =
    int => int match {
      case 1 => "Int: one"
      case 2 => "Int: two"
      case 3 => "Int: three"
      case _ => s"Int: $int"
    }

  implicit val stringCanShow: Show[String] =
    str => s"String: '$str''"
}

object ShowDemo extends App {
  import Show._
  
  println(1.show)
  println(3.show)
  println(5.show)
  println("three".show)
}