package queue;

//https://leetcode.com/problems/design-circular-queue/
public class MyCircularQueue {
	
	int[] queue;
	int front, rear, capacity;

	public MyCircularQueue(int k) {
          queue = new int[k];
          front = -1;
          rear = -1;
          capacity = k;
	}

	public boolean enQueue(int value) {
		//check if full
		if(isFull())
			return false;
		
		if(isEmpty()) {
			front++;
		}
		
		rear = (rear + 1) % capacity;
		queue[rear] = value;
		return true;

	}

	public boolean deQueue() {
		
		//check if empty
		if(isEmpty()) return false;
		
		//case when removing single element in the queue
		if(front == rear) {
			front = -1;
			rear = -1;
			return true;
		}
		
		front = (front + 1) % capacity ;
		return true;
	}

	public int Front() {
		return !isEmpty() ? queue[front] : front;

	}

	public int Rear() {
        return !isEmpty() ? queue[rear] : rear;
	}

	public boolean isEmpty() {
		return front == -1 ;
	}

	public boolean isFull() {
		return front == rear + 1 || (front == 0 && rear == capacity - 1);
	}

	
}


//Making use of length variable that will show number of elements in queue
class MyCircularQueue1 {
	
	int[] queue;
	int front = -1, rear = -1, capacity, len = 0;

	public MyCircularQueue1(int k) {
          queue = new int[k];
          capacity = k;
	}

	public boolean enQueue(int value) {
		//check if full
		if(isFull())
			return false;
		
		if(front == -1) {
			front++;
		}
		
		rear = (rear + 1) % capacity;
		queue[rear] = value;
		len++;
		return true;

	}

	public boolean deQueue() {
		
		//check if empty
		if(isEmpty()) return false;
		
		front = (front + 1) % capacity ;
		len--;
		return true;
	}

	public int Front() {
		return !isEmpty() ? queue[front] : -1;

	}

	public int Rear() {
        return !isEmpty() ? queue[rear] : -1;
	}

	public boolean isEmpty() {
		return len == 0 ;
	}

	public boolean isFull() {
		return len == capacity ;
	}

	public static void main(String[] args) {
		MyCircularQueue1 queue = new MyCircularQueue1(6);
		/*
		 * print(queue.enQueue(6)); print(queue.Rear()); print(queue.deQueue());
		 */
		print(queue.enQueue(5));
		print(queue.Rear());
		print(queue.deQueue());
		print(queue.Front());  //---
		print(queue.deQueue());
		print(queue.deQueue());
		print(queue.deQueue());


	}
	
	public static void print(Object obj) {
		System.out.println(obj);
		
	}

}
