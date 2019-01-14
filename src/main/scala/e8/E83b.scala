package e8

object E83b {
	def compose[A, B, C](ab: A => B, bc: B => C): A => C = (a: A) => bc(ab(a))

	def main(args: Array[String]): Unit = {
		val intToStringToDouble = compose(
			(i: Int) => i.toString,
			(s: String) => s.toDouble
		)

		println(intToStringToDouble(2))
	}
}
