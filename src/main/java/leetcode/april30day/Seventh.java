package leetcode.april30day;

import java.util.HashMap;
import java.util.Map;

public class Seventh {

	public int countElements(int[] arr) {

		int count = 0;
		
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for(int num : arr) {
			
			if(countMap.containsKey(num)) {
				countMap.put(num, countMap.get(num) + 1);
			}
			else {
				countMap.put(num, 1);
			}
			
		}
		
		for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			
			int key = entry.getKey() + 1;
			
			if(countMap.containsKey(key)) {
				count += countMap.get(entry.getKey());
			}
			
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Seventh obj = new Seventh();
		int[] arr = {1,1,3,3,5,5,7,7};
		System.out.println(obj.countElements(arr));
				
	}

}
