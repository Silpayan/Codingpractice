package basicalgo.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,4,2,6,4,1,7};
		
		bubbleSort(a);
		
		System.out.println("Sorted Array : ");
		for(int i:a) {
			System.out.print(i+",");
		}
	}

	private static void bubbleSort(int[] a) {
		boolean flag = true;
		for(int i = 0; i<a.length-2; i++) { //need to do length-2 pass

			//Bubble up the bigger to the last position
			for(int j = 0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) { //comparing with next 
					//swap
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = false;
				}
			}
			if(flag) break;
			
		}
	}

}
