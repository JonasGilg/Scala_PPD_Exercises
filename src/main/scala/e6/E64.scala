package e6

object E64 {
	def recursiveMult(x: Int, times: Int): Int =
		if (times == 0)
			0
		else
			recursiveMult(x, times - 1) + x

	def iterativeMult(x: Int, times: Int): Int = {
		var result = 0
		var timeCounter = times
		while (true) {
			if (times == 0)
				return result
			else {
				result += 1
				timeCounter -= 1
			}
		}

		result
	}

	def main(args: Array[String]): Unit = {

	}
}
