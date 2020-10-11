package ch.danirey.givens

import ch.danirey.enums.Color

/**
 * https://dotty.epfl.ch/docs/reference/contextual/givens.html
 */
trait Ord[T] {
  def compare(x: T, y: T): Int
  extension (x: T) def < (y: T) = compare(x, y) < 0
  extension (x: T) def > (y: T) = compare(x, y) > 0
}

given intOrd as Ord[Int] {
  def compare(x: Int, y: Int) =
    if (x < y) -1 else if (x > y) +1 else 0
}

given listOrd[T](using ord: Ord[T]) as Ord[List[T]] {

  def compare(xs: List[T], ys: List[T]): Int = (xs, ys) match
    case (Nil, Nil) => 0
    case (Nil, _) => -1
    case (_, Nil) => +1
    case (x :: xs1, y :: ys1) =>
      val fst = ord.compare(x, y)
      if (fst != 0) fst else compare(xs1, ys1)
}

given colorOrder(using ord: Ord[Int]) as Ord[Color] {
  def compare(x: Color, y: Color): Int = ord.compare(x.rgb , y.rgb)
}

object UseOrd extends App {
  val x = Color.Red
  val y = Color.Blue
 
  if (x < y)
    println(s"$x before $y")
  else
    println(s"$y before $x") 
}
