
object Curry {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def main(args: Array[String]): Unit = {
    // curry a simple sum function
    val myPlus = curry((a: Int, b: Int) => a+b)
    // partially apply 6
    val plus6  = myPlus(6)
    // take any int input and add 6
    println("Curried: args(0) plus 6 = %d".format(plus6(args(0).toInt)))
  }
}
