package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2947 {

	public static void main(String[] args) {
		
		BufferedReader inbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String[] temp = inbr.readLine().split(" ");
			int[] rubber = new int[temp.length];
			int[] sortedRubber = new int[temp.length];
			
			for(int i=0;i<temp.length;i++) {
				rubber[i] = Integer.valueOf(temp[i]);				
				sortedRubber[i] = rubber[i];
			}
			
			Arrays.sort(sortedRubber);
			
			while(true) {
				boolean isSorted = true;
				for(int i=0;i<rubber.length-1;i++)
				{
					if(rubber[i] > rubber[i+1]) {						
						swap(rubber, i, i+1);
						System.out.println(Arrays.toString(rubber).replace("[", "").replace("]", "").replace(",", ""));
					}
				}
				
				for(int i=0;i<rubber.length;i++) {
					if(rubber[i] != sortedRubber[i]) {
						isSorted = false;
						break;
					}
				}
				
				if(isSorted) {
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void swap(int[] rubber, int i, int j) {
		int temp = rubber[i];
		rubber[i] = rubber[j];
		rubber[j] = temp;
	}
}
