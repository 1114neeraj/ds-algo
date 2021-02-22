package cc.june20b.simulator.guessNumber;

import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class PlayerSimulator implements Runnable{

	private BlockingQueue<String> producerChannel;
	private BlockingQueue<String> consumerChannel;
	
	public PlayerSimulator(BlockingQueue<String> producerChannel, BlockingQueue<String> consumerChannel) {
		this.producerChannel = producerChannel;
		this.consumerChannel = consumerChannel;
	}
	
	@Override
	public void run() {
		try {
			this.guess();
		} catch (NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static class Result {
		boolean isFound = false;
		int l = 0;
		int r = 0;
		
		public Result(boolean isFound, int l, int r) {
			this.isFound = isFound;
			this.l = l;
			this.r = r;
		}
	}
	
	public void guess() throws InterruptedException {
		
		int n = Integer.parseInt(consumerChannel.take());
		
		int l = 1;
		int r = n;
		
		int k = (int)Math.ceil(Math.log(n));
		
		Stack<String> stack = new Stack<>();
		
		while(true) {
			
			Result result = binarySearch(l, r, k, stack);
			if(result.isFound) {
				break;
			}
			l = result.l;
			r = result.r;
		}
		
	}
	
	private Result binarySearch(int l, int r, int k, Stack<String> stack) throws InterruptedException {
		
		String response = "E";
		int num = 0;
		
		for(int i=0;i<k;i++) {
			
			num = (l+r)/2;
			
			System.out.println(num);
			this.producerChannel.add(num+"");
			
			response = this.consumerChannel.take();
			
			if(response.equalsIgnoreCase("E")) {
				return new Result(true, l, r);
			}
			
			if(stack.isEmpty()) {
				stack.add(response);
			}
			else {
				
				String lastResponse = stack.pop();
				
				if(response.equalsIgnoreCase(lastResponse)) {
					
					if(response.equalsIgnoreCase("G")) {
						l = num + 1;
					}
					else {
						r = num - 1;
					}
					
				}
				else {
					stack.add(response);
				}
				
			}
			
		}
		
		return new Result(false, l, r);
	}
	
}
