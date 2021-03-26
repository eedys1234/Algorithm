package Programmers_2020;

public class P03 {

	public static void main(String[] args) {
		
		int[][] key = {
			{0, 0, 0},
			{1, 1, 0},
			{0, 1, 1}
		};
		
		int[][] lock = {
			{1, 1, 1}, 
			{1, 1, 0}, 
			{1, 0, 1}	
		};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {

		boolean answer = false;		
		int[][] extendLock = new int[lock.length + 2 * (key.length) - 1][lock[0].length + 2 * (key[0].length) - 1];
		
		for(int i=0;i<lock.length;i++)
		{
			for(int j=0;j<lock[0].length;j++)
			{
				extendLock[i+(key.length-1)][j+(key[0].length-1)] = lock[i][j];
			}
		}
		
		//90도 방향 이동
		for(int k=0;k<4;k++) 
		{
			key = rotate90Key(key);
			
			for(int i=0;i<extendLock.length - key.length;i++)
			{
				for(int j=0;j<extendLock[0].length - key[0].length;j++)
				{
					if(isEqualTo(key, extendLock, lock, i, j)) {
						return true;
					}
				}
			}
		}

		return answer;
	}
	
	public static boolean isEqualTo(int[][] key, int[][] extendLock, int[][] lock, int startY, int startX) {
		
		int[][] check = new int[lock.length][lock[0].length];
		int n = lock.length;
		int cnt = 0;

		for(int i=0;i<lock.length;i++) 
		{
			for(int j=0;j<lock.length;j++) 
			{
				check[i][j] = lock[i][j];
			}
		}
				
		for(int i=startY;i<startY + key.length;i++)
		{
			for(int j=startX;j<startX + key[0].length;j++)
			{
				if(j >= (key.length-1) && j < key.length-1+lock.length && 
						i >= (key.length-1) && i < key.length-1+lock.length) {
					
					check[i-(key.length-1)][j-(key[0].length-1)] = extendLock[i][j] + key[i-startY][j-startX];
				}
			}			
		}
		
		for(int i=0;i<check.length;i++) 
		{
			for(int j=0;j<check[0].length;j++) 
			{
				if(check[i][j] == 1) {
					cnt++;
				}
			}			
		}
		
		return cnt == n * n;
	}
	
	public static int[][] rotate90Key(int[][] key) {
//		90도로 회전 시 
//		1열은 1행으로 
//		1행 1열은 1행 n열로
//		n행 1열은 1행 1열로
//
//		n열은 n행으로
//		1행 n열은 n행 n열로
//		n행 n열은 n행 1열로		
		
		int[][] rotateKey = new int[key.length][key[0].length];
		
		for(int i=0;i<key.length;i++) 
		{
			for(int j=0;j<key[0].length;j++)
			{
				rotateKey[j][key.length-i-1] = key[i][j];
			}
		}
		
		return rotateKey;
	}
}
