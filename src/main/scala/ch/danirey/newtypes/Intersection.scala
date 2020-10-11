package ch.danirey.newtypes

/**
 * https://dotty.epfl.ch/docs/reference/new-types/intersection-types.html
 */
trait Growable[T] {
  def add(t: T): Unit
}

trait Resettable {
  def reset(): Unit
}

trait Show {
  def show: String
}

def f(x: Resettable & Growable[String] & Show) = {
  x.reset()
  x.add("first")
  x.add("seconed")
  println(x.show)
  x.reset()
  println(x.show)
}

class Text extends Growable[String] with Resettable with Show {
  var s = ""
  override def add(t: String): Unit = s += t
  override def reset(): Unit = s = ""
  override def show: String = s"Text is: $s"
}

class ReverseText extends Growable[String] with Resettable with Show {
  var s = ""
  override def add(t: String): Unit = s = t + s
  override def reset(): Unit = s = ""
  override def show: String = s"ReverseText is: $s"
}

object IntersectionDemo extends App {
  f(new Text())
  f(new ReverseText())
}
