package e8

object E84 {
	type Logger = String => Unit
	type Decorator = Logger => Logger

	def main(args: Array[String]): Unit = {
		val logger: Logger = (s: String) => println(s)
		val upperCaseLogger: Decorator = (l: Logger) => (s: String) => l(s.toUpperCase)
		val infoLogger: Decorator = (l: Logger) => (s: String) => l("info: " + s)

		val prefixUpperCase = infoLogger(upperCaseLogger(logger))
		val upperCasePrefix = upperCaseLogger(infoLogger(logger))

		prefixUpperCase("This is prefixed and then uppercased")
		upperCasePrefix("This is uppercased and then prefixed")
	}
}
