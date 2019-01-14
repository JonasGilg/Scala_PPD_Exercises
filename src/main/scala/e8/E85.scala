package e8

object E85 {
	def isFactor(f: Int, n: Int): Boolean = n % f == 0

	def factorize(number: Int): List[Int] =
		(2 to math.sqrt(number).toInt).foldLeft(List[Int]())(
			(l, i) =>
				if(isFactor(i, number))
					i :: (number / i) :: l
				else
					l
		)

	def main(args: Array[String]): Unit = {
		val result = factorize(237)
		println(result)
	}
}
