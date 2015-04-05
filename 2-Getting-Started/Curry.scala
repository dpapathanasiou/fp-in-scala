
object Curry {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => (b: B) => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b) 
  }

  def main(args: Array[String]): Unit = {
    // curry a simple sum function
    val myPlus = curry((a: Int, b: Int) => a+b)
    // partially apply 6
    val plus6  = myPlus(6)
    // take any int input and add 6
    println("Curried: args(0) plus 6 = %d".format(plus6(args(0).toInt)))

    // and now uncurry the prior curried fn
    val myRegularPlus = uncurry(myPlus)
    println("Uncurried: args(0) plus args(1) = %d".format(myRegularPlus(args(0).toInt, args(1).toInt)))
  }
}
