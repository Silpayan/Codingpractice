package leetcode;

public class DaysofYear {
	
    
	public static void main(String s[]) {
		
		System.out.println("Days for 2019-01-09 : "+dayOfYear("2019-01-09"));
		
		System.out.println("Days for 2019-02-10 : "+dayOfYear("2019-02-10"));
		
		System.out.println("Days for 2003-03-01 : "+dayOfYear("2003-03-01"));
		
		System.out.println("Days for 2004-03-01 : "+dayOfYear("2004-03-01"));
		
		System.out.println("Days for 1900-03-25 : "+dayOfYear("1900-03-25"));
		
		
	}
	
	public static int dayOfYear(String date) {
        
        String s[] = date.split("-");
        
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        int feb = 28;
        int days = day;
        
        System.out.println("Day: "+ day+ " Month : "+" Year : "+year);
        
        if(year%4 == 0 && year%100 != 0 || year%400 == 0){
            //calculating leap year
            feb=29;
            System.out.println(year+" is a Leap Year");
        }
        
        for (int mon=1; mon<month;mon++){
	        if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10) {
	               days=days+31;
	        } else 
	        	if( mon == 2 ) {
	               	days= days+feb;
	        	}else {
	        		days=days+30;
	            }
	        }
	        
        
        return days;
    }

}
