
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

  // exercise 3.2
  def tail[L](list: MyList[L]): MyList[L] =
    list match {
      case Nil => Nil
      case Cons(_, tail) => tail
    }

  // exercise 3.3
  def setHead[A, L](a: L, list: MyList[L]): MyList[L] =
    list match {
      case Nil => Nil
      case Cons(_, t) => Cons(a, t)
    }

  // exercise 3.4
  def drop[L](list: MyList[L], n: Int): MyList[L] =
    if( 0 == n)
      list
    else list match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n-1)
    }

  // exercise 3.5
  def dropWhile[L](list: MyList[L], fun: L => Boolean): MyList[L] =
    list match {
      case Cons(head, tail) if fun(head) => dropWhile(tail, fun)
      case _ => list
    }

  // exercise 3.6
  def init[L](list: MyList[L]): MyList[L] =
    list match {
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(head, tail) => Cons(head, init(tail))
    }

  def foldRight[L,X](list: MyList[L], x: X)(fun: (L, X) => X): X =
    list match {
      case Nil => x
      case Cons(head, tail) => fun(head, foldRight(tail, x)(fun))
    }

  // exercise 3.7
  // product() using foldRight()
  def product(numbers: MyList[Double]) =
    foldRight(numbers, 1.0)((x,y) => x * y)

  /* product() terminating early?
     no, b/c to quote the book:
     "foldRight must traverse all the way to the end of the list (pushing framesonto the call stack as it goes) before it can begin collapsing it."
  */

  // exercise 3.9
  def length[L](list: MyList[L]): Int =
    foldRight(list, 0)((_,len) => 1+len)

  // exercise 3.10
  def foldLeft[L,X](list: MyList[L], x: X)(fun: (X, L) => X): X =
    list match {
      case Nil => x
      case Cons(head, tail) => foldLeft(tail, fun(x, head))(fun)
    }

  // exercise 3.11
  def sumLeft (numbers: MyList[Int]) =
    foldLeft(numbers, 0)(_ + _)

  def prodLeft(numbers: MyList[Double]) =
    foldLeft(numbers, 1.0)(_ * _)

  def lenLeft[L](list: MyList[L]): Int =
    foldLeft(list, 0)((len, _) => 1+len)

}
