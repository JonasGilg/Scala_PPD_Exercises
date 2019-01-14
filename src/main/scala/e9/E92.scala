package e9

object E92 {
	def main(args: Array[String]): Unit = {
		val cities = SimpleList("Hannover", "London", "Berlin")
		val primesUnder30 = SimpleList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
	}
}

abstract class SimpleList[+Elem] {

	private class ListNode[Elem](hd: Elem, tl: SimpleList[Elem]) extends SimpleList[Elem] {
		override def head: Elem = hd
		override def tail: SimpleList[Elem] = tl
		override def isEmpty = false
	}

	def head: Elem
	def tail: SimpleList[Elem]
	def isEmpty: Boolean

	def ::[NewElem >: Elem] (newHead: NewElem): SimpleList[NewElem] = new ListNode(newHead, this)

	override def toString: String = "[" + elementsToString + "]"

	private def elementsToString: String = {
		if (isEmpty)
			""
		else
		if (!tail.isEmpty)
			head.toString + ", " + tail.elementsToString
		else
			head.toString
	}

	def length: Int = {
		if (isEmpty) 0
		else 1 + tail.length
	}

	def map[Res](f: Elem => Res): SimpleList[Res] =
		if (isEmpty)
			EmptyList
		else
			f(head) :: tail.map(f)

	def count(f: Elem => Boolean): Int =
		if (isEmpty)
			0
		else
		if (f(head))
			tail.count(f) + 1
		else
			tail.count(f)

	def foldRight[Res](start: Res)(f: (Elem, Res) => Res): Res =
		if(isEmpty)
			start
		else
			f(head, tail.foldRight(start)(f))
}

object EmptyList extends SimpleList[Nothing] {
	override def head = throw new NoSuchElementException
	override def tail = throw new NoSuchElementException
	override def isEmpty = true
}

object SimpleList {
	def apply[Elem](args: Elem*): SimpleList[Elem] =
		if (args.isEmpty)
			EmptyList
		else
			args.head :: apply(args.tail :_*)
}