package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P12904 {

public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {									
			String lineS = inbr.readLine();
			String lineT = inbr.readLine();
			
			// t -> s·Î			
			while(lineT.length() != lineS.length()) {
				
				if(lineT.charAt(lineT.length()-1) == 'A') {
					lineT = lineT.substring(0, lineT.lastIndexOf('A'));
				}
				else {
					lineT = lineT.substring(0, lineT.lastIndexOf('B'));				
					StringBuilder sb = new StringBuilder();
					sb.append(lineT);
					lineT = sb.reverse().toString();
				}
			}
			
			if(lineT.equals(lineS)) {
				System.out.println("1");
			}
			else {
				System.out.println("0");				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
