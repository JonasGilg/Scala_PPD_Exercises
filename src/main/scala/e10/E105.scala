package e10

object E105 extends App {
	def closureProducer: () => Int = {
		println("closureProducer started." + this.getClass)

		val result = () => {
			println("In closure" + this.getClass + " " + this)
			return () => 0
		}

		println("closureProducer ends." + this.getClass + " " + this)
		result
	}

	val closure = closureProducer

	println("Invoking closure" + this.getClass + " " + this)
	closure()
	println("Finished" + this.getClass)
}
