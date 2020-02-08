package aam;

import java.util.TreeMap;

public class PrimeSum {
	



    static TreeMap sums;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Get the sum of all prime numbers up to N. primeSum(N). 
		 * Follow-up: If primeSum(N) is frequently called, how to optimize it. 
		 */
		primeSum(31);
	}


	    public PrimeSum(int n) { //input the upper limit for all Ns
	        sums = new TreeMap<>();
	        // init an array to track prime numbers
	        boolean[] primes = new boolean[n + 1];
	        for (int i = 2; i < n; i++)
	            primes[i] = true;
	        for (int i = 2; i <= Math.sqrt(n); i++) {
	            if (primes[i]) {
	                for (int j = i + i; j < n; j += i)
	                    primes[j] = false;
	            }
	        }
	        // insert sums into cache
	        int sum = 0;
	        for(int i = 2; i <= n; i++) {
	            if(primes[i]) {
	                sums.put(i - 1, sum);
	                sum += i;
	            }
	        }
	        if(primes[n]) {
	            sums.put(n, sum);
	        }
	    }

	    public static int primeSum(int N) {
	        int ceiling = (int) sums.ceilingKey(N);
	        //if(ceiling == null) {
	            //Exception("input value overflows");
	        //}
	        return (int) sums.get(ceiling);
	    }


}
