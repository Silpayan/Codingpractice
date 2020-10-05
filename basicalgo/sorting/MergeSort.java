package basicalgo.sorting;

public class MergeSort {

	public static void main(String args[]) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		MergeSort ob = new MergeSort();
		ob.mergeSort(arr, 0, n - 1);

		System.out.println("sorted array : ");
		printArray(arr);
	}
	
	
	private void mergeSort(int[] arr, int l, int h) {
		if(l<h) {
			int mid = (l+h)/2;
			
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,h);
			merge(arr,l,mid,h);
		}
		
	}


	private void merge(int[] arr, int l, int mid, int h) {
		// TODO Auto-generated method stub
		
	}


	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
