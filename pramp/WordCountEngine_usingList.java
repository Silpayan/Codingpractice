package pramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCountEngine_usingList {

	
	static String[][] wordCountEngine(String document) {
	    // your code goes here
	    
	    Map<String, Integer> frq = new HashMap<>();
	    Map<String, Integer> firstPos = new HashMap<>();
	    
	    int pos = 0;
	    
	    String[] words = document.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
	    
	    for(String s: words){ //a n b m b a
	          //a,n,b,m,b,"a",
	      
	      frq.put(s, frq.getOrDefault(s,0)+1); //a-2, n-1, b-2, m-1
	      
	      if(!firstPos.containsKey(s)){ //a-0, n-1, b-2, m-3
	        firstPos.put(s,pos++);
	      }
	    }
	    
	    //PriorityQueue<String> q = new PriorityQueue<String>(
	    //                              (a,b)->frq.get(a)==frq.get(b)? firstPos.get(b) - firstPos.get(a):frq.get(b)-frq.get(a));
	    
	    List<String> list = new ArrayList<String>(frq.keySet());
	    
	    Collections.sort(list, (a,b)->frq.get(a)==frq.get(b)? firstPos.get(a) - firstPos.get(b):frq.get(b)-frq.get(a) );
	                     
	                     /*new Comparator<String>{
	                    @Override
	                    compare(String a, String b){
	                        return frq.get(a)==frq.get(b)? firstPos.get(b) - firstPos.get(a):frq.get(b)-frq.get(a);
	                    } });*/
	    /*for(String s: frq.keySet()){
	      q.add(s);
	    } */
	    //System.out.println(q);
	    
	    String res[][] = new String[list.size()][2];
	    int i = 0;
	    for(String s:list){ //s:q
	      res[i][0] = s;
	      res[i][1] = Integer.toString(frq.get(s));
	      i++;
	    }
	    
	    return res;
	  }
	
	public static void main(String[] args) {
		
		String result1[][] = wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!");

		System.out.println("Result1 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}
		
		result1 = wordCountEngine(
				"Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ");

		System.out.println("Result2 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}
		
		result1 = wordCountEngine("Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up");

		System.out.println("Result3 : ");
		for (String[] a : result1) {
			System.out.println(a[0] + ", " + a[1]);
		}
	}

}
