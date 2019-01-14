package e10

object E101 {
	def curried[A, B, R](f: (A, B) => R): A => B => R = (a: A) => (b: B) => f(a, b)

	def main(args: Array[String]): Unit = {
		val charAt = (s: String, n: Int) => s(n)
		val curriedCharAt = curried(charAt)
		val hannoverAt = curriedCharAt("Hannover")
		println(hannoverAt(4)) // prints the character o
	}
}
