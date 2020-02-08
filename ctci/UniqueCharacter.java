package ctci;

public class UniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isUniqueNoXtraSpace("paglez"));
		
		System.out.println(isUniqueNoXtraSpace("pagla"));

	}
	
	public static boolean isUnique(String str) {
		if(str.length()>128)
			return false;
		
		boolean isUnique[] = new boolean[128]; //Considering ASCII checking only 128 possible character 
		for(char c : str.toCharArray()) {
			if( isUnique[c] )
				return false;
			else 
				isUnique[c] = true;
		}
		
		return true;
	}
	
	public static boolean isUniqueNoXtraSpace(String str) {
		int checker = 0;
		
		for(char c : str.toCharArray()) {
			int val = c-'a';
			int and = checker & (1<<val);
			
			System.out.print(c+" "+val +" "+and);
			
			if(and>0)
				return false;
			
			checker |= (1 << val);	
			System.out.println(" checker : "+checker);
		}
		
		return true;
	}

}
