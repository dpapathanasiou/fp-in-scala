
object Sorted {
  // define some 'ordered' functions for different types
  private def dblAsc (a: Double, b: Double): Boolean = (a <= b)
  private def intAsc (a: Int, b: Int): Boolean = (a <= b)

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def checkAtIndex(n: Int): Boolean = {
      if ((n+1) >= as.length) true // got all the way through array w/o unordered pairs
      else if (! ordered(as(n), as(n+1))) false // found an unordered pair, so stop
      else checkAtIndex(n+1)
    }
    checkAtIndex(0)
  }

  def main(args: Array[String]): Unit = {
    if (isSorted(Array(7,6,2,4,5,3), intAsc))
      println("List 1: True")
    else
      println("List 1: False") // expect this

    if (isSorted(Array(3,6,9,12,22), intAsc))
      println("List 2: True") // expect this
    else
      println("List 2: False")

    if (isSorted(Array(3.4,5.6,8.9,2.3), dblAsc))
      println("List 3: True")
    else
      println("List 3: False") // expect this

  }
}
