package e8

object E82 {
	def and(list: List[Boolean]): Boolean =
		list.foldLeft(true)( _ && _ )

	def main(args: Array[String]): Unit = {

		println(and(List(true, false, true)))
	}
}
