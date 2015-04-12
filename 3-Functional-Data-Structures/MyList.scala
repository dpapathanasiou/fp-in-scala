
sealed trait MyList [+L] // L is an arbitrary type

case object Nil extends MyList[Nothing]

case class Cons[+L](h: L, t: MyList[L]) extends MyList[L]

object MyList {
  // need to define apply() to allow MyList
  // to be to take parameters at instantiation
  def apply[L](as: L*): MyList[L] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  // needed for exercise 3.1
  def sum(ints: MyList[Int]): Int =
    ints match {
      case Nil=>0
      case Cons(x,xs) => x + sum(xs)
  }
}
