package aam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int truckSpace = 90;
		int packagesSpace[] = {1, 10, 15, 35, 45};
		//List<Integer> packagesSpace = Arrays.asList(l);
		
		knapsack(truckSpace, packagesSpace );
	}

	private static void knapsack(int truckSpace, int packagesSpace[]) {

		int maxcPackSize = 0, packIndex1 = Integer.MAX_VALUE, packIndex2 = Integer.MAX_VALUE;
		int truckAllowSpace = truckSpace-30, largerPackSize = 0;
		
		for(int i =0; i<packagesSpace.length;i++) {
			
			//check for Package and it is less than fltDuration -30? and bigger than maxcPackSize
			if(packagesSpace[i] <= truckAllowSpace && maxcPackSize<= packagesSpace[i]) {
				maxcPackSize = packagesSpace[i];
				System.out.println("Suitable Package is at "+i +" Posision and duration is "+packagesSpace[i]);
				//break;
				packIndex1 = i;
				packIndex2 = i;
				largerPackSize = packagesSpace[i]>largerPackSize?packagesSpace[i]:largerPackSize;
			}
			
			for (int j=i+1 ;j<packagesSpace.length; j++) {
				
				int combinedDuration = packagesSpace[i]+packagesSpace[j];
				//to find out if there is a pair bigger than that and also fltDuration -30
				//then that becomes a select and you continue the loop
				if (combinedDuration <= truckAllowSpace && maxcPackSize <= combinedDuration ) {
					
					if (largerPackSize < packagesSpace[i] || largerPackSize < packagesSpace[j]) {
						maxcPackSize = combinedDuration;
						packIndex1 = i;
						packIndex2 = j;
						largerPackSize = packagesSpace[i]>packagesSpace[j]?packagesSpace[i]: packagesSpace[j];
						//continue for next combination
					}
				}
				
				/*System.out.println("Suitable Packages are at "+i +" and "+j +
						" Posision and duration is "+packagesSpace[i]+" and "+packagesSpace[j]
								+" = "+ maxcPackSize);*/
				
			}
		}
		System.out.println("Suitable Packages are at "+packIndex1 +" and "+packIndex2 +
				" Posision and duration is "+packagesSpace[packIndex1]+" and "+packagesSpace[packIndex2]
						+" = "+ maxcPackSize);
		
	}

}
