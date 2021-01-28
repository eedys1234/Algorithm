package Sort;

public class QuickSort {

	public static void main(String[] args) {

		int[] data = {9, 8, 7, 6, 5, 4, 3, 2, 3};
		
		quick_sort(data, 0, data.length - 1);
		
		printData(data);
	}

	public static void printData(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	public static void quick_sort(int[] data, int p, int r) {
		
		if(p < r) {
			int q = partition(data, p, r);
			quick_sort(data, p, q-1);
			quick_sort(data, q+1, r);
		}
		
	}
	
	public static int partition(int[] data, int p, int r) {
		
		//pivot보다 작은 값들 중 마지막을 가리키는 i 값 설정
		int i = p-1;
		//pivot 설정
		int x = data[r];
		
		for(int j=p;j<r;j++) {
			if(x > data[j]) {
				i+=1;
				swap(data, i, j);
			}				
		}			
		
		return r;
	}
	
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[j] = data[i];
		data[i] = temp;
	}
}
