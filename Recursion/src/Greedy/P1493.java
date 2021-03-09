package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1493 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] temp = inbr.readLine().split(" ");
			
			int L = Integer.valueOf(temp[0]);
			int W = Integer.valueOf(temp[1]);
			int H = Integer.valueOf(temp[2]);
			
			int n = Integer.valueOf(inbr.readLine());
			int[] cube = new int[n];
			
			long res = 0;
			long before = 0;
			
			for(int i=0;i<n;i++) {
				temp = inbr.readLine().split(" ");
				cube[Integer.valueOf(temp[0])] = Integer.valueOf(temp[1]);
			}
			
			for(int i=n-1;i>=0;i--) {
			
				//2의 제곱근으로 나누기때문에 L/W/H 2*2*2 = 8을 곱해준다.
				before <<= 3;
				
				//박스를 2^i로 분할  한 후 개수에서 이전에 담았었던 큐브를 뺀다(위의 8를 곱한건 같은 크기의 큐브로 통일학 위해서)
				long possibleCubeCnt = (long)(L >> i) * (W >> i) * (H >> i) - before;
				
				//2^i 크기의 큐브 갯수만큼
				long newCube = Math.min(cube[i], possibleCubeCnt);
				
				//넣을 수 있는 큐브 추가
				before+=newCube;
				res+=newCube;
			}
			
			//큐브를 다 넣었을경우
			if(before == (long)L*W*H) {
				System.out.println(res);
			}
			else {
				System.out.println("-1");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
