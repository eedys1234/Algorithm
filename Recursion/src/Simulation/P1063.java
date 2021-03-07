package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1063 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			String king = temp[0];
			String stone = temp[1];
			int n = Integer.valueOf(temp[2]);
			String[] orders = new String[n];

			for(int i=0;i<n;i++) {
				orders[i] = inbr.readLine();
			}
			
			int kingX = king.charAt(0);
			int kingY = king.charAt(1);
			int stoneX = stone.charAt(0);
			int stoneY = stone.charAt(1);
			
			for(int i=0;i<orders.length;i++) {
				
				int moveKingX = 0;
				int moveKingY = 0;
				int moveStoneX = 0;
				int moveStoneY = 0;
				
				String[] order = new String[orders[i].length()];
				int[] c = new int[2];
				
				for(int j=0;j<order.length;j++) {
					
					order[j] = String.valueOf(orders[i].charAt(j));
					
					if(order[j].equals("T")) {
						c[0] = 1;
					}
					else if(order[j].equals("B")) {
						c[0] = -1;
					}
					else if(order[j].equals("L")) {
						c[1] = -1;
					}
					else if(order[j].equals("R")) {
						c[1] = 1;
					}					
				}
				
				moveKingY = kingY + c[0];
				moveKingX = kingX + c[1];				
				
				if(moveKingY == stoneY && moveKingX == stoneX) {
					moveStoneY = stoneY + c[0];
					moveStoneX = stoneX + c[1];					
				}
				else {
					moveStoneY = stoneY;
					moveStoneX = stoneX;										
				}
				
				if(moveKingY >= '1' && moveKingY <= '8' && moveKingX >= 'A' && moveKingX <= 'H'
						&& moveStoneY >= '1' && moveStoneY <= '8' && moveStoneX >= 'A' && moveStoneX <= 'H') {					
					kingY = moveKingY;
					kingX = moveKingX;
					stoneY = moveStoneY;
					stoneX = moveStoneX;										
				}			
				
			}
			
			System.out.println(String.valueOf((char)kingX)+String.valueOf((char)kingY));
			System.out.println(String.valueOf((char)stoneX)+String.valueOf((char)stoneY));			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
