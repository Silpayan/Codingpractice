package pramp;

import java.util.HashMap;

public class FlattenaDictionary {


	static HashMap<String, String> res;
	  
	  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
	    // your code goes here
	    
	    /*for(String s:dict.keySet()){
	      
	      Object o = dict.get(s);
	      
	      if(o instanceof String){
	        
	        res.put(s, (String)o);
	      } else{
	        flattenDictionary(o, s);
	      }
	    }*/
	    res = new HashMap<>();
	    
	    flattenDictionary(dict, "");
	    
	    return res;
	    
	  }
	  
	  static void flattenDictionary(HashMap<String, Object> dict, String key) { //dict ""
	    
	    for(String s:dict.keySet()){ //key = key2.c.e s = "" 
	      
	      Object o = dict.get(s); //"1"
	      
	      if(o instanceof String){//true
	        
	        if(s.equals("")){
	          res.put(key, (String)o); //key2.c.e : "1"
	        } else{
	          if(key.equals("")){//"" key2.a: 2
	            res.put(s, (String)o);//
	          } else{
	          res.put(key+"."+s, (String)o);
	          }
	        }
	        
	      } else{//
	        if(key.equals("")){
	          flattenDictionary((HashMap<String, Object>)o, s);  //o s 
	        } else {
	          flattenDictionary((HashMap<String, Object>)o, key+"."+s);//prepend  key+"."
	        }
	      }
	    }
	    
	  }

	public static void main(String[] args) {
		
		HashMap<String,Object> dict = new HashMap<>();
		buildDict(dict);
	    System.out.println(flattenDictionary(dict));
	}
	
	public static void buildDict(HashMap<String, Object> dict) {
		
		dict.put("Key1" , "1");
	    HashMap<String,Object> o = new HashMap<>();
	    o.put("a","2");
	    o.put("b","3");
	    HashMap<String,Object> o1 = new HashMap<>();
	    o1.put("d", "3");
	    HashMap<String,Object> o2 = new HashMap<>();
	    o2.put("", "1");
	    o1.put("e", o2);
	    o.put("c",o1);
	    dict.put("Key2", o);
	    
	    /*	"Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }*/
	}

/*
 * Object
 * 
 * Sting flatten appending key+value map.add(newkey, String) HashMap Object =
 * get(key)
 * 
 */

}
