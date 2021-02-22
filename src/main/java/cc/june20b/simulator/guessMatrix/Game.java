package cc.june20b.simulator.guessMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Game {

	public static void main(String[] args) throws Exception {
		
		ExecutorService executor = Executors.newFixedThreadPool(8);
		List<Future<Void>> futures = new ArrayList<>();
		
		int sizeOfMatrix = 60;
		int count = 72;
		
		int[][] matrix = createMatrix(sizeOfMatrix, count);
		
		futures.addAll(createGame(Strategy.BINARY_SEARCH_ON_MATRIX, matrix, executor));
		futures.addAll(createGame(Strategy.PER_POINT_QUERY, matrix, executor));
		futures.addAll(createGame(Strategy.BINARY_SEARCH_PER_ROW, matrix, executor));
		futures.addAll(createGame(Strategy.PER_ROW_QUERY_OPTIMISED, matrix, executor));
		futures.addAll(createGame(Strategy.MATRIX_OPTIMISED, matrix, executor));
		
		for(Future<Void> future : futures) {
			future.get();
		}
		
		System.out.println("Game completed");
		
//		print(matrix);
		
		executor.shutdown();
		
	}
	
	private static List<Future<Void>> createGame(Strategy strategy, int[][] matrix, ExecutorService executor) throws Exception {
		
		List<Future<Void>> futures = new ArrayList<>();
		
		BlockingQueue<Message> channelA = new ArrayBlockingQueue<>(1);
		BlockingQueue<Message> channelB = new ArrayBlockingQueue<>(1);
		
		Runnable graderWorker = new Thread(new Grader(channelA, channelB, matrix));
		Runnable playerWorker = new Thread(getPlayer(strategy, channelB, channelA));
		
		futures.add((Future<Void>) executor.submit(graderWorker));
		futures.add((Future<Void>) executor.submit(playerWorker));
		
		return futures;
	}
	
	private static Player getPlayer(Strategy strategy, BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) throws Exception {
		
		if(Strategy.BINARY_SEARCH_ON_MATRIX.equals(strategy)) {
			return getBinarySearchOnMatrixStrategyPlayer(producerChannel, consumerChannel);
		}
		else if(Strategy.PER_POINT_QUERY.equals(strategy)) {
			return getPerPointQueryStrategyPlayer(producerChannel, consumerChannel);
		}
		else if(Strategy.BINARY_SEARCH_PER_ROW.equals(strategy)) {
			return getBinarySearchPerRowStrategyPlayer(producerChannel, consumerChannel);
		}
		else if(Strategy.PER_ROW_QUERY_OPTIMISED.equals(strategy)) {
			return getPerRowQueryOptimisedStrategyPlayer(producerChannel, consumerChannel);
		}
		else if(Strategy.MATRIX_OPTIMISED.equals(strategy)) {
			return getMatrixOptimisedStrategyPlayer(producerChannel, consumerChannel);
		}
		
		throw new Exception("Strategy not found!");
	}
	
	private static Player getBinarySearchOnMatrixStrategyPlayer(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) {
		Scorer scorer = new Scorer();
		PlayerStrategy playerStrategy = new BinarySearchOnMatrixStrategy(producerChannel, consumerChannel, scorer);
		return new Player(playerStrategy, scorer);
	}
	
	private static Player getPerPointQueryStrategyPlayer(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) {
		Scorer scorer = new Scorer();
		PlayerStrategy playerStrategy = new PerPointQueryStrategy(producerChannel, consumerChannel, scorer);
		return new Player(playerStrategy, scorer);
	}
	
	private static Player getBinarySearchPerRowStrategyPlayer(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) {
		Scorer scorer = new Scorer();
		PlayerStrategy playerStrategy = new BinarySearchPerRowStrategy(producerChannel, consumerChannel, scorer);
		return new Player(playerStrategy, scorer);
	}
	
	private static Player getPerRowQueryOptimisedStrategyPlayer(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) {
		Scorer scorer = new Scorer();
		PlayerStrategy playerStrategy = new PerRowQueryOptimisedStrategy(producerChannel, consumerChannel, scorer);
		return new Player(playerStrategy, scorer);
	}
	
	private static Player getMatrixOptimisedStrategyPlayer(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel) {
		Scorer scorer = new Scorer();
		PlayerStrategy playerStrategy = new MatrixOptimisedStrategy(producerChannel, consumerChannel, scorer);
		return new Player(playerStrategy, scorer);
	}
	
	private static int[][] createMatrix(int sizeOfMatrix, int count) {
		
		int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
		
		Random random = new Random();
		
		int tempCount = 0;

		while(tempCount!=count) {
			int i = random.nextInt(sizeOfMatrix);
			int j = random.nextInt(sizeOfMatrix);
			
			if(matrix[i][j] == 0) {
				matrix[i][j] = 1;
				tempCount++;
			}
		}
		
		return matrix;
	}
	
	private static void print(int[][] matrix) {
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
}
