package cs;

public class Decode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(decode("2[a3[b]]"));
		//System.out.println(decode("xv2[a]l3[b]"));
		System.out.println(decode("2[a3[b]]vb"));
		System.out.println(decode("xvhfkrb"));
	}

	
	private static String decode(String code) {
		
		if(code.isEmpty()) {
			return "";
		}
		
		System.out.println(code);
		
		StringBuffer decodeS = new StringBuffer();
		int i=0, n=code.length();
		
		while( i<n && Character.isAlphabetic(code.charAt(i)) ) {
			decodeS.append(code.charAt(i));
			i++;
		}
		
		if(i<n) {//some number is present
			int num = Character.getNumericValue(code.charAt(i));
			i++;
			String s = decode(code.substring(i+1, code.lastIndexOf(']')));
			code = code.substring(code.lastIndexOf(']')+1, n);
			for(int cnt = 0;cnt<num;cnt++) {
				decodeS.append(s);
			}
			
			if(code.length()>0)
				decodeS.append(code);
		}
		
		
		return decodeS.toString();
	}
}
