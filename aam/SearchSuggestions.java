package aam;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SearchSuggestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String customerQuery = "mousepad";
		List<String> repository = new ArrayList<String>(); 
		//repository.add("bags");repository.add("baggage");repository.add("banner");repository.add("box");repository.add("cloths");
		repository.add("mobile");repository.add("mouse");repository.add("moneypot");repository.add("monitor");repository.add("mousepad");
		//"mobile","mouse","moneypot","monitor","mousepad"
		int numreviews = 5;
		System.out.println(new SearchSuggestions().threeKeywordSuggestions(numreviews, repository, customerQuery));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<List<String>> threeKeywordSuggestions(int numreviews, List<String> repository, String customerQuery) {
		// WRITE YOUR CODE HERE

		// Checking the edge case
		if (customerQuery == null || repository == null || repository.size() != numreviews) {
			return null;
		}

		List<List<String>> suggestions = new ArrayList<List<String>>(customerQuery.length()*2);

		// Sorting the list of i/p
		Collections.sort(repository);
		System.out.println(repository);

		// build Arraylist of threeKeywordSuggestions
		// build List of List

		for (int i = 1; i < customerQuery.length(); i++) {
			List<String> sug = new ArrayList<String>();
			for (int j = 0; j < repository.size(); j++) {
				if (sug.size() < 3 && repository.get(j).length() > i
						&& repository.get(j).subSequence(0, i + 1).equals(customerQuery.subSequence(0, i + 1))) {
					sug.add(repository.get(j));
					System.out.println(
							customerQuery.subSequence(0, i + 1) + " " + repository.get(j).subSequence(0, i + 1));
				}
				// else if(i!=0 && )
			}
			System.out.println(sug);
			suggestions.add(i-1, sug);
		}

		return suggestions;
	}
	// METHOD SIGNATURE ENDS
	/*
	 * suggestions
	 */
}
