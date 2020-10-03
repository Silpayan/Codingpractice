package javadoc;

/*
 * This is a demo lass for documentation
 * any comment in this section becomes comment for the java doc usually written by developers
 * 
 *  Output of this code -
 *  	Result is : 30
 *		Result String is : good boy
 */
public class SampleDoc {

	public static void main(String[] args) {

		SampleDoc sd = new SampleDoc();//Creating Sample class Object
		
		int result = sd.sum(10,20);//this is a method calling using SampleDoc class Object
		
		sd.display(result);//calling display method using same object to display the result
		
		String str = sd.addString("good", "boy");//this is a method calling using SampleDoc class Object
		
		sd.displayString(str);//calling display method using same object to display the result
	}


	/*
	 * This method take integers as input and returns their sum which is also integer type
	 * if a java doc creation tool can be run on this code then it would build a doc adding these commented part.
	 */
	private int sum(int a, int b) {
		int sum = a+b;
		
		return sum;
	}

	/*
	 * This method take integers as input print it in the console(Black UI screen).
	 * if a java doc creation tool can be run on this code then it would build a doc adding these commented part.
	 */
	private void display(int result) {
		
		System.out.println("Result is : "+result);
	}
	
	/*
	 * This method take Strings as input and returns their concatenation separated by a " " which is also of string type
	 * if a java doc creation tool can be run on this code then it would build a doc adding these commented part.
	 */
	private String addString(String string1, String string2) {
		String concat = string1+" "+string2;
		return concat;
	}

	/*
	 * This method take String as input print it in the console(Black UI screen).
	 * if a java doc creation tool can be run on this code then it would build a doc adding these commented part.
	 */
	private void displayString(String str) {
		System.out.println("Result String is : "+str);		
	}
}
