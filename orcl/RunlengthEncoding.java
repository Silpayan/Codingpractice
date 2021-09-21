package orcl;

public class RunlengthEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "abcccddeeeeea";//"aaa" //a3 //"aaaabbb";//a4b3//"";// //"abcdefgfed";//same //"abcccddeeeeea"; //abc3d2e5a
		System.out.println(new RunlengthEncoding().compressString(s));
	}
	
	private String compressString(String str) {
		
		if(str==null||str.length()==0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		for(int i=0;i<str.length();i++) {
			
			if(i!=0) {
				if(str.charAt(i-1)==str.charAt(i)) {
					count++;
				} else {
					if(count!=1) {
						sb.append(count);
						count=1;
					}
				}
			}
			
			if(count == 1) {
				sb.append(str.charAt(i));
			}
				
		}
		
		if(count!=1) {
			sb.append(count);
		}
		
		return sb.toString();
	}

}
