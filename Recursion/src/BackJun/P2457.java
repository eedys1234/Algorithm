package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2457 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(inbr.readLine());
			List<Period> periods = new ArrayList<>(n);
			
			for(int i=0;i<n;i++) {
				String[] temp = inbr.readLine().split(" ");

				int startMonth = Integer.valueOf(temp[0]);
				int startDay = Integer.valueOf(temp[1]);
				int endMonth = Integer.valueOf(temp[2]);
				int endDay = Integer.valueOf(temp[3]);				
				
				periods.add(new Period(startMonth, startDay, endMonth, endDay));
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static class Period {
		
		int startMonth;
		int startDay;
		int endMonth;
		int endDay;
		
		public Period(int startMonth, int startDay, int endMonth, int endDay) {
			this.startMonth = startMonth;
			this.startDay = startDay;
			this.endMonth = endMonth;
			this.endDay = endDay;
		}
	}
}
