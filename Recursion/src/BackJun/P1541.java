package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1541 {
	
	public static void main(String[] args) {

		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		
		try {
			String line = inbr.readLine();	
			String[] minus = null;
			
			if(line.indexOf("-")>-1) {
				minus = line.split("-");				
			}
			else {
				minus = line.split("\\+");								
				for(int i=0;i<minus.length;i++) {
					result += Integer.valueOf(minus[i]);
				}
				System.out.println(result);

				return;
			}
			
			for(int i=0;i<minus.length;i++) 
			{
				String[] plus = null;
				if(minus[i].indexOf("+") > -1) {
					plus = minus[i].split("\\+");					
				}
				else {
					plus = new String[1];
					plus[0] = minus[i];
				}
				int sum = 0;
				for(int j=0;j<plus.length;j++) 
				{
					sum += Integer.valueOf(plus[j]);
				}
				minus[i] = String.valueOf(sum);
				
				if(i==0) {
					result += Integer.valueOf(minus[i]);					
				}
				else {
					result -= Integer.valueOf(minus[i]);
				}
			}
			
			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
