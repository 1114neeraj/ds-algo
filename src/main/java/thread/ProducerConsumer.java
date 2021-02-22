package thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	private static class Producer implements Runnable {
		
		private Queue<Character> queue;
		private int bufferSize;
		
		public Producer(Queue<Character> queue, int bufferSize) {
			this.queue = queue;
			this.bufferSize = bufferSize;
		}
		
		@Override
		public void run() {
			produce();
		}
		
		private void produce() {
			while(true) {
				synchronized (queue) {
					
					while(queue.size() == bufferSize) {
						try {
							System.out.println("queue is full");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					queue.add('P');
					queue.notifyAll();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	private static class Consumer implements Runnable {

		private Queue<Character> queue;
		private int bufferSize;
		
		public Consumer(Queue<Character> queue, int bufferSize) {
			this.queue = queue;
			this.bufferSize = bufferSize;
		}
		
		@Override
		public void run() {
			consume();
		}
		
		private void consume() {
			
			while(true) {
				
				synchronized (queue) {
					
					while(queue.isEmpty()) {
						try {
							System.out.println("queue is empty");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					System.out.println(queue.remove());
					
					queue.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Queue<Character> queue = new LinkedList<>();
		Producer producer = new Producer(queue, 5);
		Consumer consumer = new Consumer(queue, 5);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
        consumerThread.join();
	}
	
}
