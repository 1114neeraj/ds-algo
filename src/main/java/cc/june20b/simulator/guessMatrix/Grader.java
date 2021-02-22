package cc.june20b.simulator.guessMatrix;

import java.util.concurrent.BlockingQueue;

public class Grader implements Runnable{

	private BlockingQueue<Message> producerChannel;
	private BlockingQueue<Message> consumerChannel;
	private int[][] matrix;
	private int sizeOfMatrix;
	
	public Grader(BlockingQueue<Message> producerChannel, BlockingQueue<Message> consumerChannel, int[][] matrix) {
		this.producerChannel = producerChannel;
		this.consumerChannel = consumerChannel;
		this.matrix = matrix;
		this.sizeOfMatrix = matrix.length;
	}
	
	private int count(int r1, int c1, int r2, int c2) {
		int count = 0;
		
		for(int i=r1-1;i<=r2-1;i++) {
			for(int j=c1-1;j<=c2-1;j++) {
				if(this.matrix[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean compareToGameMatrix(int[][] matrix) {
		
		for(int i=0;i<sizeOfMatrix;i++) {
			for(int j=0;j<sizeOfMatrix;j++) {
				
				if(this.matrix[i][j] != matrix[i][j]) {
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	@Override
	public void run() {
		try {
			this.process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void process() throws InterruptedException {
		
//		System.out.println(this.sizeOfMatrix);
		this.producerChannel.add(new Message(this.sizeOfMatrix, -1, -1, -1, -1, -1, -1, null));
		
		Message message = null;
		
		while(true) {
			
			message = this.consumerChannel.take();
			
			if(message.getActionFlag() == 1) {
				int count = this.count(message.getR1(), message.getC1(), message.getR2(), message.getC2());
//				System.out.println(count);
				this.producerChannel.add(new Message(-1, count, -1, -1, -1, -1, -1, null));
			}
			else if(message.getActionFlag() == 2) {
//				System.out.println(this.compareToGameMatrix(message.getMatrix()));
//				this.print(this.matrix);
//				System.out.println();
//				this.print(message.getMatrix());
				break;
			}
			
		}
		
	}
}
