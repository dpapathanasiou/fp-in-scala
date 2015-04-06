
object Compose {
  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => {
      val gx = g(a)
      f(gx)
    }
  }

  def main(args: Array[String]): Unit = {
    // test that compose works, using example from book
    val f = (x: Double) => math.Pi / (2-x)

    // f andThen g is the same as g compose f
    // val cos = f andThen math.sin

    // let's use our homebrew compose instead
    val cos = compose(math.sin, f)

    // confirm it works
    println("Cosine by composition: cos(args(0)) = %f".format(cos(args(0).toDouble)))
  }
}
