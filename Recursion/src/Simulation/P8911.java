package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P8911 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
				
			int t = Integer.valueOf(inbr.readLine());
			StringBuilder sb = new StringBuilder();
			
			while(t-- > 0) { 
				String command = inbr.readLine();
				//처음시작은 북쪽
				int direction = 0;
				int y = 0;
				int x = 0;
				int minY = 0;
				int maxY = 0;
				int minX = 0;
				int maxX = 0;
				
				//위: 0, 왼: 1, 아래: 2, 오른: 3
				for(int i=0;i<command.length();i++) {
					
					char ch = command.charAt(i);
					//왼쪽 방향
					if(ch == 'L') {
						if(direction == 3) direction = 0;
						else direction++;
					}
					//오른쪽 방향
					else if(ch == 'R') {
						if(direction == 0) direction = 3;
						else direction--;
					}
					
					//직진
					if(ch == 'F') {
						switch (direction) {
						case 0:
							y--;
							break;
						case 1:
							x--;
							break;
						case 2:
							y++;
							break;

						default:
							x++;
							break;
						}
					}
					//후진
					else if(ch == 'B') {
						switch (direction) {
						case 0:
							y++;
							break;
						case 1:
							x++;
							break;
						case 2:
							y--;
							break;

						default:
							x--;
							break;
						}						
					}

					minY = Math.min(minY, y);
					maxY = Math.max(maxY, y);
					minX = Math.min(minX, x);
					maxX = Math.max(maxX, x);

//					System.out.println(minX + " ~ " + maxX + ", "+ minY + " ~ " + maxY);
				}
				
				sb.append(Math.abs(maxX - minX) * Math.abs(maxY - minY)).append("\n");
			}
			
			System.out.println(sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
