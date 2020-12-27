package Recursion;

public class TaillCalls <T> {

	public static <T> TailCall<T> call(TailCall<T> nextCalls) {
		return nextCalls;
	}
	
	public static <T> TailCall<T> done(T value) {
		return new TailCall<T>() {

			@Override
			public TailCall<T> apply() {
				throw new IllegalArgumentException();
			}
			
			@Override
			public boolean isComplete() {
				return true;
			}
			
			@Override
			public T result() {
				return value;				
			}
			
		};
	}
}
