package ch.danirey.optionalbraces

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
