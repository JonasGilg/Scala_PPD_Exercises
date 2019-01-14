package e6

object E61 {
	type IntFun = Int => Int

	def max(f: IntFun, g: IntFun): IntFun = x => {
		val fx = f(x)
		val gx = g(x)

		if (fx > gx)
			fx
		else
			gx
	}

	def main(args: Array[String]): Unit = {
		val tripler = (x: Int) => 3 * x
		val square = (x: Int) => x * x
		val maxTriplerSquare = max(tripler, square)
		for (i <- 1 to 5)
			println(maxTriplerSquare(i))
	}
}
