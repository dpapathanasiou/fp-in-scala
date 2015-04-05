
object Fibonacci {
  def fib(n: Int): Int = {
    // this is a simple, declarative function
    // (it works, but is not tail-recursive)
    if (0 == n || 1 == n) n
    else fib(n-2) + fib(n-1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(args(0).toInt))
  }
}
