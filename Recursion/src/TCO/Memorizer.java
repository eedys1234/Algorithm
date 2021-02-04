package TCO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Memorizer {

	public static <T,R> R callMemoized(BiFunction<Function<T, R>, T, R> function, T input) {
		
		Function<T, R> memo = new Function<T, R>() {

			private Map<T, R> store = new ConcurrentHashMap<T, R>();

			@Override
			public R apply(T input) {
				return store.computeIfAbsent(input, key->function.apply(this, input));
			}
		};
		
		return memo.apply(input);		
	}
}
