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
  }
}
