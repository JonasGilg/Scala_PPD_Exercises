package e8;

import java.util.function.Function;

public class E83 {
	static Function<Integer, Integer> compose(Function<Integer, Integer> f,
	                                          Function<Integer, Integer> g) {
		return x -> f.apply(g.apply(x));
	}

	public static void main(String[] args) {
		Function<Integer, Integer> triple = x -> 3 * x;
		Function<Integer, Integer> inc = x -> x + 1;
		Function<Integer, Integer> incThenTriple = compose(triple, inc);
	}
}
