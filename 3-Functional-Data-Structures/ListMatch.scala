import MyList._

object ListMatch {

  def main(args: Array[String]): Unit = {
    // this is the definition of exercise 3.1    
    val x = MyList(1,2,3,4,5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil=>42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x+y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }
    println("x is now %d".format(x))

    // and some tests of exercise 3.2
    val stringList = MyList("a", "b", "c", "d")
    val doubleList = MyList(1.0, 2.0, 3.5, 4.75)
    val y = MyList.tail(stringList)
    val z = MyList.tail(doubleList)
    println(y)
    println(z)

    // exercise 3.3
    val a = MyList.setHead("Z", stringList)
    val b = MyList.setHead(99.5, doubleList)
    println(a)
    println(b)
  }
}
