package leetcode.search;

public class VersionControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(firstBadVersion(2126753390));

	}

	public static int firstBadVersion(int n) {
		return firstBadVersion(1, n);
	}
	

	public static int firstBadVersion(int start, int end) {

		// if(isBadVersion(1)) return 1;
		System.out.println(start+", "+end);
		if (start >= end )
			return start;
		int mid = start+(end - start) / 2;
		boolean isMidBad = isBadVersion(mid);
		
		if (!isMidBad) {
			if(isBadVersion(mid+1)) {
				System.out.println(mid+1);
				return mid+1;
			}
			else {
				return firstBadVersion(mid, end);
			}
		} else
			{
				return firstBadVersion(start, mid);
			}
	}

	private static boolean isBadVersion(int i) {
		// TODO Auto-generated method stub
		if(i>1702766719) return true;
		return false;
	}

}
