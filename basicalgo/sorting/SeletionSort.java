package basicalgo.sorting;

public class SeletionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,2,6,4,1,7};
		
		seletionSort(a);
		
		System.out.println("Sorted Array : ");
		for(int i:a) {
			System.out.print(i+",");
		}
	}

	private static void seletionSort(int[] a) {
		
		for(int i = 0; i<a.length-1; i++) { //need to do length-2 pass
			//Assume iTh element as min
			int iMin = i;//tracking the position
			//Select actual min among i-n
			for(int j = i;j<a.length;j++) {
				if(a[j]<a[iMin])
					iMin = j;					
			}
			
			int temp = a[i];
			a[i]=a[iMin];
			a[iMin] = temp;
			//swap
		}
		
	}

}
