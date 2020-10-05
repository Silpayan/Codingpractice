package leetcode.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode", wordDict[] = {"leet", "code"};//"cars" 	["car","ca","rs"]
		System.out.println(new WordBreak().wordBreak(s, wordDict));
	}
	
    public boolean wordBreak(String s, List<String> wordDict) {
        Set parts = Collections.synchronizedSet(new HashSet<String,String>());
        
        for(String word:wordDict){
            
            if(parts.contains(word)){
                return true;
            }
            
           //if(s.contains(word)){
                parts.add(s.replaceAll(word,""));
           // }
                          
             for(String p : parts){
                 p=p.replaceAll(word,"");
                 if(p.length()==0){
                     return true;
                 }
                 parts.add(p);
             }
        }
        
        return false;
    }

}
