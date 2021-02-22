package cc.june20b.simulator.guessNumber;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GuessSimulator implements Runnable{
	
	private BlockingQueue<String> producerChannel;
	private BlockingQueue<String> consumerChannel;
	
	public GuessSimulator(BlockingQueue<String> producerChannel, BlockingQueue<String> consumerChannel) {
		this.producerChannel = producerChannel;
		this.consumerChannel = consumerChannel;
	}
	
	@Override
	public void run() {
		try {
			this.grader();
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void grader() throws NumberFormatException, InterruptedException {
		
		int n = 10;
		
		System.out.println(n);
		this.producerChannel.add(n+"");
		Random random = new Random();
		
		int value = random.nextInt(n + 1);
		
		int input = 0;
		
		int choice = random.nextInt(2);
		
		while(true) {
			
			input = Integer.parseInt(this.consumerChannel.take());
			
			if(input == value) {
				break;
			}
			
			// TRUTH
			if(choice == 1) {
				if(input > value) {
					this.producerChannel.add("L");
					System.out.println("L");
				}
				else {
					this.producerChannel.add("G");
					System.out.println("G");
				}
			}
			// LIE
			else {
				if(input > value) {
					this.producerChannel.add("G");
					System.out.println("G");
				}
				else {
					this.producerChannel.add("L");
					System.out.println("L");
				}
			}
			
//			choice = choice == 0 ? 1 : random.nextInt(2);
			choice = choice == 0 ? 1 : 0;
		}
		this.producerChannel.add("E");
		System.out.println("E");
		
	}
	
}
