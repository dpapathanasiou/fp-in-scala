
object Fibonacci {
  def fib(n: Int): Int = {
    @annotation.tailrec
    def calc(n: Int, pr: Int, nx: Int): Int = {
      if (0 == n) pr
      else calc(n-1, nx, pr+nx)
    }
    // using tail-recursive local fn:
    // pr=prior, nx=next fibonacci numbers
    calc(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(args(0).toInt))
  }
}
