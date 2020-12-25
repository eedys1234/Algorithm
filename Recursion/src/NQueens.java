
public class NQueens {

	public static int N = 4;
	public static int[] cols = new int[N+1];
	
	public static void main(String[] args) {
		
		queens(0);
	}
	
	public static boolean queens(int level) {
		
		//�ش� �࿡ ���� �� �ִ��� ���� Ȯ��
		if(!check(level)) {
			return false;
		}
		//��� �࿡ ���� ���
		else if(level == N) {
			for(int i=1;i<=level;i++) {
				System.out.println(i + "," + cols[i]);				
			}
			return true;
		}
		//�� �� ���
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
