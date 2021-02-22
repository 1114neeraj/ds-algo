package cc.june20b.simulator.guessNumber;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Player implements Runnable{

	private BlockingQueue<String> producerChannel;
	private BlockingQueue<String> consumerChannel;
	
	public Player(BlockingQueue<String> producerChannel, BlockingQueue<String> consumerChannel) {
		this.producerChannel = producerChannel;
		this.consumerChannel = consumerChannel;
	}
	
	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(System.in);
			this.guess(scanner);
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void guess(Scanner scanner) throws NumberFormatException, InterruptedException {
		
		int n = Integer.parseInt(consumerChannel.take());
		
		int num = 0;
		String response = null;
		
		while(!"E".equalsIgnoreCase(response)) {
			num = Integer.parseInt(scanner.nextLine());
			this.producerChannel.add(num+"");
			response = this.consumerChannel.take();
		}
	}

}
