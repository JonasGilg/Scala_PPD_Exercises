package e6

object E62 {
	type IntFun = Int => Int

	def compose(f: IntFun, g: IntFun): IntFun = x => f(g(x))

	def mychain(f: IntFun, times: Int): IntFun =
		if (times == 1)
			f
		else
			compose(mychain(f, times - 1), f)

	def main(args: Array[String]): Unit = {
		//val double = (x: Int) => x + 1
		val fourTimes = mychain((x: Int) => x*x, 3)

		val compose: (IntFun, IntFun) => IntFun =
			(f, g) => { x => f(g(x)) }

		// Using method definition syntax:
		def chain(n: Int, f: Int => Int): Int => Int =
			if (n == 1) f
			else compose(chain(n-1, f), f)  // or compose(f, chain(n-1, f))

		val toPowerOf8 = chain(3, (x: Int) => x*x)


		for (i <- 0 to 5) {
			println(fourTimes(i))
			println(toPowerOf8(i))
			println("####")
		}
	}
}
