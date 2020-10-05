package leetcode.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class RankTeamsbyVotes5345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String votes[] = //{"BCA","CAB","CBA","ABC","ACB","BAC"};//{"M","M","M","M"};//{"ABC","ACB","ABC","ACB","ACB"};//{"WXYZ","XYZW"};//{"ABC","ACB","ABC","ACB","ACB"};
			   {"FVSHJIEMNGYPTQOURLWCZKAX","AITFQORCEHPVJMXGKSLNZWUY","OTERVXFZUMHNIYSCQAWGPKJL","VMSERIJYLZNWCPQTOKFUHAXG",
				"VNHOZWKQCEFYPSGLAMXJIUTR","ANPHQIJMXCWOSKTYGULFVERZ","RFYUXJEWCKQOMGATHZVILNSP","SCPYUMQJTVEXKRNLIOWGHAFZ",
				"VIKTSJCEYQGLOMPZWAHFXURN","SVJICLXKHQZTFWNPYRGMEUAO","JRCTHYKIGSXPOZLUQAVNEWFM","NGMSWJITREHFZVQCUKXYAPOL",
				"WUXJOQKGNSYLHEZAFIPMRCVT","PKYQIOLXFCRGHZNAMJVUTWES","FERSGNMJVZXWAYLIKCPUQHTO","HPLRIUQMTSGYJVAXWNOCZEKF",
				"JUVWPTEGCOFYSKXNRMHQALIZ","MWPIAZCNSLEYRTHFKQXUOVGJ","EZXLUNFVCMORSIWKTYHJAQPG","HRQNLTKJFIEGMCSXAZPYOVUW",
				"LOHXVYGWRIJMCPSQENUAKTZF","XKUTWPRGHOAQFLVYMJSNEIZC","WTCRQMVKPHOSLGAXZUEFYNJI"};
			       /*{"FSHJIEMNGYPTQOURLWCZKAX","AITFQORCEHPJMXGKSLNZWUY","OTERXFZUMHNIYSCQAWGPKJL","MSERIJYLZNWCPQTOKFUHAXG",
					"NHOZWKQCEFYPSGLAMXJIUTR","ANPHQIJMXCWOSKTYGULFERZ","RFYUXJEWCKQOMGATHZILNSP","SCPYUMQJTEXKRNLIOWGHAFZ",
					"IKTSJCEYQGLOMPZWAHFXURN","SJICLXKHQZTFWNPYRGMEUAO","JRCTHYKIGSXPOZLUQANEWFM","NGMSWJITREHFZQCUKXYAPOL",
					"WUXJOQKGNSYLHEZAFIPMRCT","PKYQIOLXFCRGHZNAMJUTWES","FERSGNMJZXWAYLIKCPUQHTO","HPLRIUQMTSGYJAXWNOCZEKF",
					"JUWPTEGCOFYSKXNRMHQALIZ","MWPIAZCNSLEYRTHFKQXUOGJ","EZXLUNFCMORSIWKTYHJAQPG","HRQNLTKJFIEGMCSXAZPYOUW",
					"LOHXYGWRIJMCPSQENUAKTZF","XKUTWPRGHOAQFLYMJSNEIZC","WTCRQMKPHOSLGAXZUEFYNJI"};*/
		//Ans: "VWFHSJARNPEMOXLTUKICZGYQ"
		
		System.out.println(new RankTeamsbyVotes5345().rankTeams(votes));
	}
	
public String rankTeams(String[] votes) {
        
        int countV = 0;
        String result = "";
        Map<Character, Integer> teamRank = new HashMap<Character, Integer>();
        
        System.out.println(teamRank);
        
        for(String team :votes) {
        	for(int i=0;i<team.length();i++) {
        		char c = team.charAt(i);
                
        		teamRank.put(c, teamRank.getOrDefault(c, 0)+i);//less value means better position
        		
        		if(c=='V') {
                	countV+=i;
                	System.out.println(countV+", "+teamRank.get(c));
                }
        	}
        	
        	 
        }
        
        System.out.println(countV);
        
        System.out.println(teamRank);
        
        Set<Character> keys = teamRank.keySet();
        
        char teams[] = new char[keys.size()];
        
        
        PriorityQueue<Character> sortedByFrq =
	            new PriorityQueue<Character>((w1,w2) -> teamRank.get(w1).equals(teamRank.get(w2)) ? 
	            		w1.compareTo(w2) : teamRank.get(w1)-teamRank.get(w2));
	    /*
	    *Lamda expression for sorting
	    *1. if frequency is same then compare the words
	    *2. Else higher frequency words go first
	    */

	    // keep k top frequent elements in the heap
	    for (Character c: teamRank.keySet()) {
	      sortedByFrq.add(c);
	    }

	    while (!sortedByFrq.isEmpty())
	    	result += sortedByFrq.poll();
        
        return result;
    }

}
