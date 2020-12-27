package Recursion;
import java.util.Scanner;

public class Perm {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] arg = line.split("\\s");
			int n = Integer.valueOf(arg[0]);
			int m = Integer.valueOf(arg[1]);
			
			int[] iset = new int[n];
			
			for(int i=1;i<=n;i++) {
				iset[i-1] = i;
			}
			
			perm(iset, m, 0);
			
		}
	}
	
	public static void perm(int[] iset, int m, int k) {

		if(k == m) {
			for(int i=0;i<m;i++) {
				System.out.print(iset[i] + " ");				
			}
			System.out.println();
		}
		
		for(int i=k;i<iset.length;i++) {
			swap(iset, i, k);
			perm(iset, m, k+1);
			swap(iset, i, k);
		}
	}
	
	public static void swap(int[] iset, int i, int k) {
		int temp = iset[i];
		iset[i] = iset[k];
		iset[k] = temp;
	}
}
