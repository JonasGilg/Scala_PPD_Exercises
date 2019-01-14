package e6

object E63 {
	var dontChangeMe: Int = 0

	def impureAdd(x: Int, y: Int): Int = {
		dontChangeMe += 1
		x + y + dontChangeMe
	}

	def main(args: Array[String]): Unit = {

	}
}
