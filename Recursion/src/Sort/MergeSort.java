package Sort;

public class MergeSort {

	public static void main(String[] args) {

		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		merge_sort(data, 0, data.length - 1);

		for(int i=0;i<data.length;i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	
	public static void merge_sort(int[] data, int p, int r) {
		

		if(p < r) {
			int q = (p+r)/2;
			merge_sort(data, p, q);
			merge_sort(data, q+1, r);
			merge(data, p, q, r);
		}
		
	}

	public static void merge(int[] data, int p, int q, int r) {
		
		int i = p;
		int j = q+1;
		int k = p;
		int[] temp = new int[data.length]; 

		while(i<=q && j<=r) {
			if(data[i] < data[j]) {
				temp[k++] = data[i++];
			}
			else {
				temp[k++] = data[j++];				
			}
		}
		
		while(i<=q) {
			temp[k++] = data[i++];
		}
		
		while(j<=r) {
			temp[k++] = data[j++];			
		}
		
		for(int l=p;l<=r;l++) {
			data[l] = temp[l];
		}
	}
	
}
