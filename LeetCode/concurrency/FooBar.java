package leetcode.concurrency;

public class FooBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 private int n;

	    public FooBar(int n) {
	        this.n = n;
	    }

	    public void foo(Runnable printFoo) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	            
	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	Thread.yield();
	        }
	    }

	    public void bar(Runnable printBar) throws InterruptedException {
	        
	        for (int i = 0; i < n; i++) {
	            
	            // printBar.run() outputs "bar". Do not change or remove this line.
	        	printBar.run();
	            Thread.yield();
	        }
	    }

}
