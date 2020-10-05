package basicalgo.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {8,2,4,2,6,4,1,7};
		
		insertionSort(a);
		
		System.out.println("Sorted Array : ");
		for(int i:a) {
			System.out.print(i+",");
		}
	}

	private static void insertionSort(int[] a) {
		for(int i = 1; i<a.length; i++) { //need to do length pass

			int val = a[i];
			int hole = i;
			
			while(hole>0 && a[hole-1]>val) {
				a[hole] = a[--hole];
			}
			
			a[hole]=val;
			
			System.out.print(i+" Th step Sorted Array : ");
			
			for(int x:a) {
				System.out.print(x+",");
			}
			
			System.out.print("\n");
			
		}
	}

	/*O/P
	 * 1 Th step Sorted Array : 2,8,4,2,6,4,1,7,
	 * 2 Th step Sorted Array : 2,4,8,2,6,4,1,7,
	 * 3 Th step Sorted Array : 2,2,4,8,6,4,1,7,
	 * 4 Th step Sorted Array : 2,2,4,6,8,4,1,7,
	 * 5 Th step Sorted Array : 2,2,4,4,6,8,1,7,
	 * 6 Th step Sorted Array : 1,2,2,4,4,6,8,7,
	 * 7 Th step Sorted Array : 1,2,2,4,4,6,7,8,
	 * Sorted Array : 
	 * 1,2,2,4,4,6,7,8,
	 */
}
