package leetcode.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input[] = {"Silpayan", "Silpay", "Silpo"};	
		System.out.println("Prefix : "+longestCommonPrefix(input));
				
	}

public static String longestCommonPrefix(String[] strs) {
	
		if(strs==null || strs.length==0) 
			return "";
		String prefix = "";
        int strCount = strs.length;
        prefix = strs[0];
        for(int i=0; i<strCount && prefix!="";i++) {
        	if(strs[i]!=null || !strs[i].equals("")) {
        		//string manupulation using substring
        		if(!strs[i].startsWith(prefix)) {
        			prefix = prefix.substring(0, prefix.length()-1);
        			i--;
        		}
        	}
        	else{
        		return "";
        	}
        }
        	
		return prefix;
    }

}
