package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 249. Group Shifted Strings
Medium

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class GroupShiftedStrings_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str[] = {"abc","bcd","acef","xyz","az","ba","a","z","mlp"};
		
		System.out.println("\nGroup Strings : "+new GroupShiftedStrings_Premium().groupStrings(str));
	}
	
	public List<List<String>> groupStrings(String[] strings) {
        
        //Create a hashmap. key is a number (the offset compared to its first char), 
        //value is a list of strings which have the same offset.
        //For each string, convert it to char array 
        //Then subtract its first character for every character
        //eg. "abc" -> "0,1,2,"        "am"->"0,12,"
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strings) {
            String key = "";
            char first = str.charAt(0);
            for(char c:str.toCharArray())
                key+=(c-first<0?c-first+26:c-first)+",";
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(str);
        }
        
        System.out.println(map);
        
        for(String key:map.keySet())
            Collections.sort(map.get(key));
        return new ArrayList<List<String>>(map.values());
    }

}
