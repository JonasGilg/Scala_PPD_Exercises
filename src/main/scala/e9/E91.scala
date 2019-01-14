package e9

object E91 {
	def multiPrint[T](args: T*): Unit =
		if (args.isEmpty)
			println()
		else {
			print(args.head)
			multiPrint(args.tail :_*)
		}

	def main(args: Array[String]): Unit = {
		multiPrint("Hello ", "World ", "Bitches", "!")
	}
}
