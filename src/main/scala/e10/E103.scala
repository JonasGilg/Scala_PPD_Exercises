package e10

object E103 extends App {
	type Pred[A] = A => Boolean

	def divisibleBy(k: Int): Pred[Int] = _ % k == 0

	def lift[A](f: (=> Boolean, => Boolean) => Boolean, g: Pred[A], h: Pred[A]): Pred[A] =
		a => f(g(a), h(a))

	def checkLifted = lift(_ || _, divisibleBy(2), divisibleBy(0))
	def checkDirect = (n: Int) => divisibleBy(2)(n) || divisibleBy(0)(n)

	println(checkDirect(4))
	println(checkLifted(4))
}
