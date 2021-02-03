package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11723 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			int m = Integer.valueOf(inbr.readLine());
			int S = 0;
			for(int i=1;i<=m;i++) {
				String line = inbr.readLine();
				String[] temp = line.split(" ");
				
				if(temp.length > 1) {
					int x = Integer.valueOf(temp[1]) - 1;
					String op = temp[0];
					
					if(op.equals("add")) {
						S = add(S, x);
					}
					else if(op.equals("check")) {
						sb.append(check(S, x));
						sb.append("\n");
					}
					else if(op.equals("remove")) {
						S = remove(S, x);
					}
					else if(op.equals("toggle")) {
						S = toggle(S, x);
					}
				}
				else {
					String op = temp[0];
					
					if(op.equals("all")) {
						S = all();
					}
					else if(op.equals("empty")) {
						S = empty();
					}
				}
			}
			
			System.out.println(sb.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static int add(int S, int x) {
		return S | (1 << x);
	}
	
	public static int remove(int S, int x) {
		return S & ~(1 << x);
	}
	
	public static int check(int S, int x) {
		return (S & (1 << x)) > 0 ? 1 : 0;
	}
	
	public static int toggle(int S, int x) {
		if(check(S, x) == 1) {
			return remove(S, x);
		}
		else {
			return add(S, x);
		}
	}
	
	public static int all() {
		return (1 << 20) -1;
	}
	
	public static int empty() {
		return 0;
	}
}
