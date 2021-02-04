package TCO;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RodCutter {
	
	private List<Integer> prices;
	
	public RodCutter(List<Integer> prices) {
		this.prices = prices;
	}

	public int maxProfit(int rodLength) {
		
		BiFunction<Function<Integer, Integer>, Integer, Integer> compute = (func, length)->{
			
			int profit = rodLength <= prices.size() ? prices.get(rodLength-1) : 0;
			
			for(int i=1;i<length;i++) 
			{
				profit = Math.max(profit, func.apply(i)+func.apply(length-i));
			}
			
			return profit;			
		};
		
		return Memorizer.callMemoized(compute, rodLength);
	}
}
