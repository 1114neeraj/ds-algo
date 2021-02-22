package cc.june20b.simulator.guessMatrix;

import java.util.concurrent.BlockingQueue;

/**
 * Strategy 2
 * @author neeraj.yogendra
 *
 */
public class PerPointQueryStrategy implements PlayerStrategy{

	private BlockingQueue<Message> producerChannel;
	private BlockingQueue<Message> consumerChannel;
	private Scorer scorer;
	
	public PerPointQueryStrategy(BlockingQueue<Message> producerChannel,
			BlockingQueue<Message> consumerChannel, Scorer scorer) {
		this.producerChannel = producerChannel;
		this.consumerChannel = consumerChannel;
		this.scorer = scorer;
	}
	
	@Override
	public void play() throws InterruptedException {
		Message message = this.consumerChannel.take();
		int sizeOfMatrix = message.getSizeOfMatrix();
		
		int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
//		System.out.println(String.format("%s %s %s %s %s", 1, 1, 1, sizeOfMatrix, sizeOfMatrix));
		this.producerChannel.add(new Message(-1, -1, 1, 1, 1, sizeOfMatrix, sizeOfMatrix, null));
		int totalCount = this.consumerChannel.take().getCount();
		this.scorer.calculateScore(sizeOfMatrix, 1, 1, sizeOfMatrix, sizeOfMatrix, totalCount);
		
		solve(matrix, 1, 1, matrix.length, matrix.length, totalCount);
		this.producerChannel.add(new Message(-1, -1, 2, -1, -1, -1, -1, matrix));
		
	}
	
	private int solve(int[][] matrix, int r1, int c1, int r2, int c2, int totalCount) throws InterruptedException {
		
		int value = 0;
		int tempCount = 0;
		
		for(int i=r1; i<=r2; i++) {
			for(int j=c1; j<=c2; j++) {
//				System.out.println(String.format("%s %s %s %s %s", 1, i, j, i, j));
				this.producerChannel.add(new Message(-1, -1, 1, i, j, i, j, null));
	            value = this.consumerChannel.take().getCount();
	            this.scorer.calculateScore(matrix.length, i, j, i, j, value);
				
				matrix[i-1][j-1] = value;
				tempCount += value;
				
				if(tempCount == totalCount) {
					return totalCount;
				}

			}
		}
		
		return totalCount;
	}

}
