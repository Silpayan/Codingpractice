package leetcode.basicds;
/*
 * 622. Design Circular Queue 
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 */
public class DesignCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DesignCircularQueue circularQueue = new DesignCircularQueue(3); // set the size to be 3
		circularQueue.enQueue(1);  // return true
		circularQueue.enQueue(2);  // return true
		circularQueue.enQueue(3);  // return true
		circularQueue.enQueue(4);  // return false, the queue is full
		circularQueue.Rear();  // return 3
		circularQueue.isFull();  // return true
		circularQueue.deQueue();  // return true
		circularQueue.enQueue(4);  // return true
		circularQueue.Rear();  // return 4
	}
	
	

    final int[] a;
        int front, rear = -1, len = 0;

        public DesignCircularQueue(int k) { a = new int[k];}

        public boolean enQueue(int val) {
            if (!isFull()) {
                rear = (rear + 1) % a.length;
                a[rear] = val;
                len++;
                return true;
            } else return false;
        }

        public boolean deQueue() {
            if (!isEmpty()) {
                front = (front + 1) % a.length;
                len--;
                return true;
            } else return false;
        }

        public int Front() { return isEmpty() ? -1 : a[front];}

        public int Rear() {return isEmpty() ? -1 : a[rear];}

        public boolean isEmpty() { return len == 0;}

        public boolean isFull() { return len == a.length;}
    
    /* 
     ***Self problem with isEmpty *** 
    int a[];
    int front, rear;

    public MyCircularQueue(int k) {
        a = new int[k];
        front=rear=k-1;
    }
    
    public boolean enQueue(int value) {
        //System.out.println(rear+", value = "+value);
        if(isFull()){//queue full
            return false;
        }
        
        if(rear==-1){
            rear=a.length-1;
        }

        a[rear--]=value;
        
        //System.out.println("After enQueue rear = "+rear);
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){ //empty queue
            return false;
        }
        if(front==0){
            a[front]=Integer.MIN_VALUE;
            front = a.length-1;
        } else 
            a[front--]=Integer.MIN_VALUE;
        
        return true;
    }
    
    public int Front() {
        if(this.isEmpty())
            return -1;
           
        return a[front];
    }
    
    public int Rear() {
        if(this.isEmpty())
            return -1;
        if(rear==a.length-1){
            System.out.println("rear = "+rear);
            return a[a.length-1];

        }
        return a[rear+1];
    }
    
    public boolean isEmpty() {
        System.out.println("isEmpty "+rear+", "+front);
         return rear==front && !isFull();// || (rear==0 && front==0);
    }
    
    public boolean isFull() {
        //System.out.println(rear+", "+front);
        if(rear-front==1 || (front==a.length-1 && rear==-1)){//queue full
            return true;
        }
        
        return false;
    }*/
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
