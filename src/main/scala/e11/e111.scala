package e11

class Posting(val date: Int, val interesting: Boolean)

object e111 extends App {
	val postings = Stream(
		new Posting(1, true),
		new Posting(2, false),
		new Posting(3, true),
		new Posting(4, false),
		new Posting(5, false),
		new Posting(6, true),
		new Posting(7, false),
		new Posting(8, false),
		new Posting(9, false),
		new Posting(10, false),
		new Posting(11, true),
		new Posting(12, false)
	)

	var interestingCounter = 0

	def interesting(posting: Posting) = {
		interestingCounter += 1
		posting.interesting
	}

	var recentCounter = 0

	val result = postings takeWhile {
			posting => recentCounter += 1; posting.date < 6
		} filter interesting

	for (elem <- result) {
		println("Date: " + elem.date)
	}

	println(interestingCounter)
	println(recentCounter)
}
