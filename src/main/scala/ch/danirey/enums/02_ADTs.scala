package ch.danirey.enums

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
