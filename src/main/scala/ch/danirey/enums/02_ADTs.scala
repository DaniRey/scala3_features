package ch.danirey.enums

/**
 * https://dotty.epfl.ch/docs/reference/enums/adts.html
 * 
 * Algebraic Data Types
 */
enum Tree[+T] {
  case Node(value: T, left: Tree[T], right: Tree[T])
  case Leaf(value: T)
}

object UseTree {
  import Tree.Node
  import Tree.Leaf
  
  val x = 
    Node("head", 
      Leaf("left"), 
      Node("right", 
        Leaf("left_right"), 
        Leaf("right_right")
      )
    ) 
}
