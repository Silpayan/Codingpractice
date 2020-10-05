package pramp;

import java.util.HashMap;

public class FlattenaDictionary {


	static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
	    // your code goes here

	    HashMap<String, String> flat = new HashMap<String, String>();
	    
	    for(String str:dict.keySet()){
	      
	      Object o = dict.get(str); //Either Object or String
	      
	      if(o instanceof String ){
	        flat.add(str, (String) o);
	      } else {
	        flattenDictionary(str,o, flat);
	      }
	    }
	  }

	private void flattenDictionary(String key, HashMap<String, Object> dict, HashMap<String, String> flat){
	    
	    for(String str:dict.keySet()){
	      
	      Object o = dict.key(str); //Either Object or String
	      
	      if(o instanceof String ){
	        flat.add(key+"."+str, (String) o);
	      } else {
	        flattenDictionary(key+"."+str,o, flat);
	      }
	  }
	}

	public static void main(String[] args) {

	}

}

/*
 * Object
 * 
 * Sting flatten appending key+value map.add(newkey, String) HashMap Object =
 * get(key)
 * 
 */

}
