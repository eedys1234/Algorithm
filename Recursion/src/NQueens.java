
public class NQueens {

	public static int N = 4;
	public static int[] cols = new int[N+1];
	
	public static void main(String[] args) {
		
		queens(0);
	}
	
	public static boolean queens(int level) {
		
		//해당 행에 놓을 수 있는지 여부 확인
		if(!check(level)) {
			return false;
		}
		//모든 행에 놓은 경우
		else if(level == N) {
			for(int i=1;i<=level;i++) {
				System.out.println(i + "," + cols[i]);				
			}
			return true;
		}
		//그 외 경우
		else {
			for(int i=1;i<=N;i++) {
				cols[level+1] = i;
				if(queens(level+1)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static boolean check(int level) {
		
		for(int i=1;i<level;i++) {
			if(cols[i] == cols[level]) {
				return false;
			}
			else if(level-i == Math.abs(cols[level] - cols[i])) {
				return false;
			}
		}
		
		return true;
	}
}
