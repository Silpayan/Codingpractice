package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1268. Search Suggestions System
 * Difficulty:Medium
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

 * Return list of lists of the suggested products after each character of searchWord is typed

 */
public class SearchSuggestionsSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String products[] = {"mobile","mouse","moneypot","monitor","mousepad"};
		//String searchWord = "mousepad";
		String products[] = {"havana"};
		String searchWord = "tatiana";
		System.out.println(suggestedProducts(products, searchWord));

	}
	
public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestions = new ArrayList<List<String>>(searchWord.length()*2);
        
        if(searchWord==null || products==null)
        	return null;
        
        Arrays.sort(products);
        
        for(int i=0;i<searchWord.length();i++) {
        	List<String> sug = new ArrayList<String>();
        	for(int j=0;j<products.length;j++) {
        		if(sug.size()<3&& products[j].length()>i && products[j].subSequence(0, i+1).equals(searchWord.subSequence(0, i+1))) {
        			sug.add(products[j]);
        			System.out.println(searchWord.subSequence(0, i+1) +" "+products[j].subSequence(0, i+1));
        		}
        		//else if(i!=0 && )
        	}
        	System.out.println(sug);
        	suggestions.add(i,sug);
        }
        return suggestions;
    }

}
