package aam;

public class FltMovie {
	public static void main (String a[]) {
		
		int movie_duration[] = {89, 710, 710, 214, 220, 270, 40};
		int maxcMovieSize = 0, movieIndex1 = Integer.MAX_VALUE, movieIndex2 = Integer.MAX_VALUE;
		int fltDuration = 1000-30, LongerMovieSize = 0;
		//Let me find out the max below 220
		//then will try to find min and then second max and second min
		
		//Other Way is to create a max heap and min heap and then compare their sum with 250-30=220
		//Depending on number of inputs we can change our approach Heap sort is O(nlog n)
		//and we have to do it twice and then 2 log n operation to find out suitable solution
		//This approach is a brute force approach.
		
		//Check for blank array
		//
			
		//System.out.println(movieIndex1+" "+movieIndex2);
		
		for(int i =0; i<movie_duration.length;i++) {
			
			//check for movie and it is less than fltDuration -30? and bigger than maxcMovieSize
			if(movie_duration[i] <= fltDuration && maxcMovieSize<= movie_duration[i]) {
				maxcMovieSize = movie_duration[i];
				System.out.println("Suitable Movie is at "+i +" Posision and duration is "+movie_duration[i]);
				//break;
				movieIndex1 = i;
				movieIndex2 = i;
				LongerMovieSize = movie_duration[i]>LongerMovieSize?movie_duration[i]:LongerMovieSize;
			}
			
			for (int j=i+1 ;j<movie_duration.length; j++) {
				
				int combinedDuration = movie_duration[i]+movie_duration[j];
				//to find out if there is a pair bigger than that and also fltDuration -30
				//then that becomes a select and you continue the loop
				if (combinedDuration <= fltDuration && maxcMovieSize <= combinedDuration ) {
					
					if (LongerMovieSize < movie_duration[i] || LongerMovieSize < movie_duration[j]) {
						maxcMovieSize = combinedDuration;
						movieIndex1 = i;
						movieIndex2 = j;
						LongerMovieSize = movie_duration[i]>movie_duration[j]?movie_duration[i]: movie_duration[j];
						//continue for next combination
					}
				}
				
				/*System.out.println("Suitable Movies are at "+i +" and "+j +
						" Posision and duration is "+movie_duration[i]+" and "+movie_duration[j]
								+" = "+ maxcMovieSize);*/
				
			}
		}
		System.out.println("Suitable Movies are at "+movieIndex1 +" and "+movieIndex2 +
				" Posision and duration is "+movie_duration[movieIndex1]+" and "+movie_duration[movieIndex2]
						+" = "+ maxcMovieSize);
		
	}

}


/*
*
*Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]

*/