package leetcode.backtracking;

/*
 * 10. Regular Expression Matching
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";//"aab";//"aaaaaa";//"mississpp";//"aaabbbccc";
		String p = "c*a*b";//"c*a*b";//"a*";//"mis*is*p*.";//"a*bb.cc*"

		System.out.println("Match ? " + isMatchLC(s, p));

	}

	public static boolean isMatch(String s, String p) {
		//Not working!
		if(s.isEmpty()) return p.isEmpty();
		
		int paternPointer = 0;
		char lastChar = '0';
		for (char c : s.toCharArray() ) {

			
			if(paternPointer>=p.length() && p.charAt(paternPointer-1)!='*')
				return false;
			System.out.println(c+"  Last : "+lastChar+" PatChar : "+p.charAt(paternPointer));
			
			if (p.charAt(paternPointer) == '*' && (lastChar == c || lastChar == '0')) {
				continue;
			} else if (p.charAt(paternPointer) == '.') {// && (lastChar == c || lastChar == '0')) {
				paternPointer++;
				continue;
			} else if (p.charAt(paternPointer) == '*' || p.charAt(paternPointer) == '.') {
				paternPointer+=1;
			}
			
			if (c != p.charAt(paternPointer)) {
//				System.out.println(paternPointer+1<p.length());
//				System.out.println('*' != p.charAt(paternPointer+1));
//				System.out.println(p.charAt(paternPointer+1));
						
				if (paternPointer+1<p.length() && '*' != p.charAt(paternPointer+1)) {
					paternPointer++;
					continue;
				} else if (paternPointer==0 && '*' == p.charAt(paternPointer+1)) {
					paternPointer++;
					continue;
					
				} else if (p.charAt(paternPointer) == '.') {// && (lastChar == c || lastChar == '0')) {
					paternPointer++;
					continue;
				}
				else {
					System.out.println(c + " != " + p.charAt(paternPointer));
					return false;	
				}
				
			} else
				lastChar = c;
			paternPointer++;
		}

		return true;
	}
	
	public static boolean isMatchLC(String s, String p) {
		 if (s == null || p == null) {
		        return false;
		    }
		    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		    dp[0][0] = true;
		    for (int i = 0; i < p.length(); i++) {
		        if (p.charAt(i) == '*' && dp[0][i-1]) {
		            dp[0][i+1] = true;
		        }
		    }
		    for (int i = 0 ; i < s.length(); i++) {
		        for (int j = 0; j < p.length(); j++) {
		            if (p.charAt(j) == '.') {
		                dp[i+1][j+1] = dp[i][j];
		            }
		            if (p.charAt(j) == s.charAt(i)) {
		                dp[i+1][j+1] = dp[i][j];
		            }
		            if (p.charAt(j) == '*') {
		                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
		                    dp[i+1][j+1] = dp[i+1][j-1];
		                } else {
		                    dp[i+1][j+1] = (dp[i+1][j] || 			// in this case, a* counts as single a
		                    					dp[i][j+1] || 		//in this case, a* counts as multiple a 
		                    						dp[i+1][j-1]); 	// in this case, a* counts as empty
		                }
		            }
		        }
		    }
		    
		    /*System.out.println("dp[][] : ");
		    for (int i = 0; i < dp.length; i++) {
		        for(int j = 0; j < dp[0].length; j++) {
		        	System.out.print(dp[i][j]+ " ");
		        }
		        System.out.println();
		    }*/
		    
		    
		    return dp[s.length()][p.length()];

	}
}
