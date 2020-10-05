package leetcode.string;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RearrangeWordsinaSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new RearrangeWordsinaSentence().arrangeWordsWord("Hi"));

		System.out.println(new RearrangeWordsinaSentence().arrangeWordsWord("Leetcode is cool"));

		System.out.println(new RearrangeWordsinaSentence().arrangeWordsWord("Keep calm and code on"));

		System.out.println(new RearrangeWordsinaSentence().arrangeWordsWord("To be or not to be"));
	}
	
	
	public String arrangeWordsBuggy(String text) { //Bug : can't diff 2 same words i.e. 'be' in "To be be or to not"

		if (text.isEmpty()) {
			return text;
		}

		String str[] = text.split(" ");

		/*
		 * if(str.length ==1){ return text; }
		 */

		PriorityQueue<String> wordP = new PriorityQueue<>(// (w1,w2) -> document.indexOf(w1) - document.indexOf(w2));
				(w1, w2) -> w1.length() != w2.length() ? w1.length() - w2.length() : text.indexOf(w1) - text.indexOf(w2));

		int n = str.length, i = 0;

		for (String word : str)
			wordP.offer(word);

		// System.out.println(wordP);

		StringBuilder sb = new StringBuilder();
		i = 0;
		// for(Word s:wordP){ //Iterator not in prority order
		// System.out.print("1 : "+s.word);
		// sb.append(s.word);
		// if(i==0) sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		// if(i!=n-1) sb.append(" ");
		// i++;
		// }

		for (i = 0; !wordP.isEmpty(); i++) {
			// System.out.print(" 2: "+wordP.peek().word);
			sb.append(wordP.poll());
			if (i == 0)
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			if (i != n - 1)
				sb.append(" ");
		}

		// return Character.toUpperCase(sb.charAt(0))+sb.substring(1, sb.length()-1);

		return sb.toString();
	}

	public String arrangeWordsWord(String text) { //Using Inner class

		if (text.isEmpty()) {
			return text;
		}

		String str[] = text.split(" ");

		/*
		 * if(str.length ==1){ return text; }
		 */

		PriorityQueue<Word> wordP = new PriorityQueue<>(// (w1,w2) -> document.indexOf(w1) - document.indexOf(w2));
				(w1, w2) -> w1.len != w2.len ? w1.len - w2.len : w1.pos - w2.pos);

		int n = str.length, i = 0;

		for (String word : str)
			wordP.offer(new Word(word.toLowerCase(), i++));

		// System.out.println(wordP);

		StringBuilder sb = new StringBuilder();
		i = 0;
		// for(Word s:wordP){ //Iterator not in prority order
		// System.out.print("1 : "+s.word);
		// sb.append(s.word);
		// if(i==0) sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		// if(i!=n-1) sb.append(" ");
		// i++;
		// }

		for (i = 0; !wordP.isEmpty(); i++) {
			// System.out.print(" 2: "+wordP.peek().word);
			sb.append(wordP.poll().word);
			if (i == 0)
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			if (i != n - 1)
				sb.append(" ");
		}

		// return Character.toUpperCase(sb.charAt(0))+sb.substring(1, sb.length()-1);

		return sb.toString();
	}

	class Word {
		String word;
		int len;
		int pos;

		public Word(String in, int pos) {
			word = in;
			this.len = in.length();
			this.pos = pos;
		}

		/*
		 * public int compareTo(Word obj2){ if(this.word.length() !=
		 * obj2.word.length()){ return obj2.len - this.word.len; } else { return
		 * obj2.pos - this.pos; } }
		 */
	}
	
    public String arrangeWordsJoin(String text) {
        String []s = text.toLowerCase().split(" ");
        Arrays.sort(s, (a,b) ->  a.length() - b.length());
        String ans = String.join(" ", s);
        return Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }
}
