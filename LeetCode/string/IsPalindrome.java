package leetcode.string;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="A man, a plan, a canal: Panama";
		String s1="0p";
		System.out.println(isPalindrome(s1));
		
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		if(s==null)
			return true;
		//s = s.replaceAll(" ", "");
		s = s.toLowerCase();
		char c[] = s.toCharArray();
		int n = c.length-1;
		for (int i = 0; i < n; ) {
			System.out.println(c[i]+" = "+c[n]+"? ");
			if(!(c[i]>='a' && c[i]<='z' || c[i]>='0' && c[i]<='9')) {
				System.out.println(c[i]+" skipping i "+i);
				i++;
				continue;
			}
			if(!(c[n]>='a' && c[n]<='z' || c[n]>='0' && c[n]<='9')) {
				System.out.println(c[n]+" skipping n "+n);
				n--;
				continue;
			}
			if (c[i++] != c[n--]) {
				return false;
			}
		}
		return true;
	}
}
