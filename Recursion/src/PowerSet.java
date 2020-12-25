
public class PowerSet {
	
	public static char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	public static int N = data.length;
	public static boolean[] include = new boolean[N];

	public static void main(String[] args) {
	
		powerset(0);
	}
	
	
	public static void powerset(int k) {		

		if(k == N) {
			for(int i=0;i<N;i++) {
				if(include[i]) {
					System.out.print(data[i] + " ");
				}
			}
			System.out.println();
			return ;
		}
		
		include[k] = false;
		powerset(k+1);
		
		include[k] = true;
		powerset(k+1);
	}
}
