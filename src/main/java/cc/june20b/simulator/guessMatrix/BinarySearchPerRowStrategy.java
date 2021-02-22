package cc.june20b.simulator.guessMatrix;

import java.util.concurrent.BlockingQueue;

/**
 * Strategy 3
 * @author neeraj.yogendra
 *
 */
public class BinarySearchPerRowStrategy implements PlayerStrategy{

	private BlockingQueue<Message> producerChannel;
	private BlockingQueue<Message> consumerChannel;
	private Scorer scorer;
	
	public BinarySearchPerRowStrategy(BlockingQueue<Message> producerChannel,
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
		
		int tempCount = 0;
		
		for(int i=r1;i<=r2;i++) {
//			System.out.println(String.format("%s %s %s %s %s", 1, i, c1, i, c2));
//			this.producerChannel.add(new Message(-1, -1, 1, i, c1, i, c2, null));
//			int count = this.consumerChannel.take().getCount();
//			this.scorer.calculateScore(matrix.length, i, c1, i, c2, count);
			tempCount += solveRow(matrix, i, c1, c2, -1);
			
			if(tempCount == totalCount) {
				break;
			}
			
		}
		
		return totalCount;
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
		
//		if(r-l+1 != array.length) {
////			System.out.println(String.format("%s %s %s %s %s", 1, i, l, i, r));
//			this.producerChannel.add(new Message(-1, -1, 1, i, l, i, r, null));
//			count = this.consumerChannel.take().getCount();
//			this.scorer.calculateScore(array.length, i, l, i, r, count);
//			
//			if(count == 0) {
//				return 0;
//			}
//			else if( count == r-l+1) {
//				for(int j=l-1;j<=r-1;j++) {
//					array[i-1][j] = 1;
//				}
//				return count;
//			}
//		}
		
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

}
