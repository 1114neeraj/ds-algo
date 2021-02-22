package cc.june20b.simulator.guessMatrix;

import java.util.concurrent.BlockingQueue;

/**
 * Strategy 5
 * @author neeraj.yogendra
 *
 */
public class MatrixOptimisedStrategy implements PlayerStrategy {

	private BlockingQueue<Message> producerChannel;
	private BlockingQueue<Message> consumerChannel;
	private Scorer scorer;

	public MatrixOptimisedStrategy(BlockingQueue<Message> producerChannel,
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
		//		this.producerChannel.add(new Message(-1, -1, 1, 1, 1, sizeOfMatrix, sizeOfMatrix, null));
		//		int totalCount = this.consumerChannel.take().getCount();
		//		this.scorer.calculateScore(sizeOfMatrix, 1, 1, sizeOfMatrix, sizeOfMatrix, totalCount);

		solve(matrix, 1, 1, sizeOfMatrix, sizeOfMatrix, -1);
		this.producerChannel.add(new Message(-1, -1, 2, -1, -1, -1, -1, matrix));
//		print(matrix);
	}
	
	private int solve(int[][] matrix, int r1, int c1, int r2, int c2, int totalCount) throws InterruptedException {

		int count = totalCount;

		if(totalCount == -1) {
//			System.out.println(String.format("%s %s %s %s %s", 1, r1, c1, r2, c2));
			this.producerChannel.add(new Message(-1, -1, 1, r1, c1, r2, c2, null));
			count = this.consumerChannel.take().getCount();
			this.scorer.calculateScore(matrix.length, r1, c1, r2, c2, count);
		}

		if(count == 0) {
			return 0;
		}
		else if(count == (r2 - r1 + 1) * (c2 - c1 + 1) ) {
			fill(matrix, r1, c1, r2, c2);
			return count;
		}

		int topHalfCount = solve(matrix, r1, c1, r2-1, c2, -1);

		if(topHalfCount + (c2-c1+1) == count) {
			fill(matrix, r2, c1, r2, c2);
			return count;
		}

		int bottomHalfCount = count - topHalfCount;

		if(bottomHalfCount > 0) {
			bottomHalfCount = solveRow(matrix, r2, c1, c2, bottomHalfCount);
		}

		return count;
	}
	
	private int solveRow(int[][] array, int i, int l, int r, int totalCount) throws InterruptedException {

		int count = totalCount;

		if(totalCount == -1) {
//			System.out.println(String.format("%s %s %s %s %s", 1, i, l, i, r));
			this.producerChannel.add(new Message(-1, -1, 1, i, l, i, r, null));
			//			count = Integer.parseInt(scanner.nextLine());
			count = this.consumerChannel.take().getCount();
			this.scorer.calculateScore(array.length, i, l, i, r, count);
		}

		if(count == 0) {
			return 0;
		}
		else if( count == r-l+1) {
			for(int j=l-1;j<=r-1;j++) {
				array[i-1][j] = 1;
			}
			return count;
		}

		int mid = (l+r)/2;

		int leftCount = solveRow(array, i, l, mid, -1);

		if(leftCount + (r-mid) == count) {
			for(int j=mid;j<=r-1;j++) {
				array[i-1][j] = 1;
			}
			return count;
		}

		int rightCount = count - leftCount;

		if(rightCount > 0) {
			rightCount = solveRow(array, i, mid + 1, r, rightCount);
		}

		return leftCount + rightCount;
	}

	private void fill(int[][] matrix, int r1, int c1, int r2, int c2) {

		for(int i=r1-1;i<=r2-1;i++) {
			for(int j=c1-1;j<=c2-1;j++) {
				matrix[i][j] = 1;
			}
		}

	}

}
