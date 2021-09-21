package pramp;

import java.util.Arrays;

public class DecryptMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(decrypt("rajsb"));
		System.out.println(decryptL("dnotq"));
		System.out.println(decrypt("flgxswdliefy"));

	}

	  static String decrypt(String word) { //3 = 78 4  = 104   5 = 130
		    // your code goes here
		    char c[] = word.toCharArray();
		    
		    for(int i = c.length-1; i>0; i--){ //100	110	111	116	113
		      
		      int a = c[i] - c[i-1]; //             116-111 = 5+104 = 109      113-116 = -3+104 = 101
		      
		      while(a<97){  //
//		        c[i] = (char)(c[i]+104);//
		        
		        a += 26;
		        //System.out.println(a);
		      }
		      
		      c[i] = (char)a;
		    }
		    
		    c[0] -= 1; //100 -1 99   102
		    
		    while(c[0]<'a'){
		        c[0] += 26;
		      }
		    
		    return new String(c);
		    
		  }
	  
	static String decryptL(String word) {

		if(word.isEmpty()){
		      return word;
		    }
		
		int n = word.length();
		char dec[] = new char[n];

		for (int i = n - 1; i > 0; i--) { // String ops costly

			//System.out.println(word.charAt(i) - word.charAt(i - 1));

			dec[i] = (char) (word.charAt(i) - word.charAt(i - 1)+26);// 100 10 1

			//System.out.println(Arrays.toString(dec));

			while (dec[i] < 'a') {
				dec[i] += 26;
				//System.out.println(dec[i]);
			}

			//System.out.println(Arrays.toString(dec));
		}

		dec[0] = (char) (word.charAt(0) - 1);

		return new String(dec);

	}

}
