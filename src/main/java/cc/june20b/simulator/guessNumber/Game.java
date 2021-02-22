package cc.june20b.simulator.guessNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Game {

	public static void main(String[] args) throws NumberFormatException, InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		BlockingQueue<String> channelA = new ArrayBlockingQueue<>(1);
		BlockingQueue<String> channelB = new ArrayBlockingQueue<>(1);
		
		Runnable simulator = new Thread(new GuessSimulator(channelA, channelB));
		Runnable player = new Thread(new Player(channelB, channelA));
		
		List<Future<Void>> futures = new ArrayList<>();
		
		futures.add((Future<Void>) executor.submit(simulator));
		futures.add((Future<Void>) executor.submit(player));
		
		for(Future<Void> future : futures) {
			future.get();
		}
		
		System.out.println("Found");
		
		executor.shutdown();
		
	}

}
