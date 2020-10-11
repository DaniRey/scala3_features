package ch.danirey.explicitnulls

/**
 * Explicit Nulls is opt-in with the feature flag
 *  -Yexplicit-nulls
 * https://dotty.epfl.ch/docs/internals/explicit-nulls.html
 */
object Nulls extends App {
  val a: String | Null = null
  
  //this would not compile
  //val a: String = null

  //thanks to flow-typing the type of `a` is String inside the if block
  if (a != null)
    println(a.length)
  else
    println("null")
}
