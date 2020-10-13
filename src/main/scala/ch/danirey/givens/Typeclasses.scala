package ch.danirey.givens

trait Show[T]:
  extension (x: T) def show: String

given Show[Int]:
  extension (x: Int) def show: String = 
    x match
        case 1 => "Int: one"
        case 2 => "Int: two"
        case 3 => "Int: three"
        case _ => s"Int: $x"

given Show[String]: 
  extension (x: String) def show: String = s"String: '$x'"

object ShowDemo extends App {
  println(1.show)
  println(3.show)
  println(5.show)
  println("three".show)
}
