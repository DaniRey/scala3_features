package ch.danirey.optionalbraces

/**
 * https://dotty.epfl.ch/docs/reference/other-new-features/indentation.html
 */
trait A:
  def f: Int

class C(x: Int) extends A:
  def f = x

object D:
  def isFavorite(x: Int) = 
    if (x == 42)
      println("wuhuuu")
      true
    else 
      false

object O:
  def f = 3
