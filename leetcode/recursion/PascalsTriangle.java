package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String s[]) {
		
		System.out.println(generate(1, 2, null));
	}
	//Hoyni
public static List<List<Integer>> generate(int currentRowNum, int numRows,List<List<Integer>> result) {
	//List<List<Integer>> result=new ArrayList<List<Integer>>();;
	List<Integer> currentRow=new ArrayList<Integer>();
	if(currentRowNum ==0 || currentRowNum== numRows) {
		return null;
	} else
		if(currentRowNum == 1) {
			currentRow.add(1);
			result.add(currentRow);
			return result;
		}
	
	
	generate(currentRowNum+1, numRows , result);
	
	return result;
    }
}
