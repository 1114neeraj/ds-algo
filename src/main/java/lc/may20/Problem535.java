package lc.may20;

import java.util.HashMap;
import java.util.Map;

public class Problem535 {

    public int findJudge(int N, int[][] trust) {
    	
    	Map<Integer, Integer> voteMap = new HashMap<>();
    	
    	for(int i=0;i<trust.length;i++) {
    		
    		int memberIdx = trust[i][0];
    		int tmpJudgeIdx = trust[i][1];
    		
    		if(voteMap.containsKey(memberIdx)) {
    			voteMap.remove(memberIdx);
    		}
    		
    		if(voteMap.containsKey(tmpJudgeIdx)) {
    			voteMap.put(tmpJudgeIdx, voteMap.get(tmpJudgeIdx) + 1);
    		}else {
    			voteMap.put(tmpJudgeIdx, 1);
    		}
    		
    	}
    	
    	if(voteMap.size() == 0 && N == 1) {
    		return 1;
    	}
    	
    	for(Map.Entry<Integer, Integer> entry : voteMap.entrySet()) {
    		if(entry.getValue() == N-1) {
    			return entry.getKey();
    		}
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
		Problem535 obj = new Problem535();
		int[][] trust = new int[1][2];
		trust[0][0] = 1;
		trust[0][1] = 2;
		System.out.println(obj.findJudge(2, trust));
	}
	
}
