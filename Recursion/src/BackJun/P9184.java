package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9184 {
	
	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		int a = 0, b = 0, c = 0;
		String line = null;
		String[] temp = null;
		int[][][] value = new int[51][51][51];	
		
		try {

			while(true) {

				line = inbr.readLine();			
				temp = line.split(" ");
				a = Integer.valueOf(temp[0]);
				b = Integer.valueOf(temp[1]);
				c = Integer.valueOf(temp[2]);
				
				if(a == -1 && b == -1 && c == -1) {
					break;
				}
				/*
				else {
					a = a<0?0:a;
					b = b<0?0:b;
					c = c<0?0:c;					
				}*/
				
				System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(value, a, b, c));
			}
						
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static int w(int[][][] value, int a, int b, int c) {
		

		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if(value[a][b][c] > 0) {
		}
		else if(a > 20 || b > 20 || c > 20) {
			value[a][b][c] = w(value, 20, 20, 20);
		}
		else if(a < b && b < c) {
			value[a][b][c] = w(value, a, b, c-1) + w(value, a, b-1, c-1) - w(value, a, b-1, c);
		}
		else {
			value[a][b][c] = w(value, a-1, b, c) + w(value, a-1, b-1, c) + w(value, a-1, b, c-1) - w(value, a-1, b-1, c-1);																		
		}

		return value[a][b][c];
	}
} 