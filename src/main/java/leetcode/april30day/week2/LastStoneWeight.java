package leetcode.april30day.week2;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		
		if(stones.length == 0) {
			return 0;
		}
		
		if(stones.length == 1) {
			return stones[0];
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int stone : stones) {
			maxHeap.add(stone);
		}
		
		while(maxHeap.size() >1 ) {
			
			int maxA = maxHeap.poll();
			int maxB = maxHeap.poll();
			
			int value = maxA-maxB;
			
			if(value!=0) {
				maxHeap.add(value);
			}
			
		}
		
		if(maxHeap.isEmpty()) {
			return 0;
		}
		
		return maxHeap.poll();
		
	}
	
	public static void main(String[] args) {
		LastStoneWeight obj = new LastStoneWeight();
		
		int[] stones = {2,7,4,1,8,1};
		
		System.out.println(obj.lastStoneWeight(stones));
		
	}
	
}
