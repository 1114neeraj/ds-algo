package cc.june20b;

public class TTUPLE {

	public static void main(String[] args) {
		
		int[] initialState = {3, 5, 7};
		int[] finalState = {6, 5, 10};
		
		findSubStrings(initialState, finalState);
	}
	
	private static void findSubStrings(int[] initialState, int[] finalState) {
		
		if(initialState[0] == finalState[0] && initialState[1] == finalState[1] && initialState[2] == finalState[2]) {
			System.out.println(String.format("%s %s %s", initialState[0], initialState[1], initialState[2]));
			return;
		}
		
		System.out.println(String.format("%s %s %s", initialState[0], initialState[1], initialState[2]));
		
		int[] intermediateState = initialState;
		
		int max = getMax(finalState);
		
		for(int k=1;k<=max;k++) {
			
			for(int i=1;i<=7;i++) {
				
				int mask = 1;
				
				boolean isContinue = false;
				
				for(int j=0;j<initialState.length;j++) {
					
					if((i & mask) > 0) {
						
						if(intermediateState[j] + k <= finalState[j]) {
							intermediateState[j] = intermediateState[j] + k;
							isContinue = true;
						}
						
					}
					
					mask = mask << 1;
					
				}
				if(isContinue) {
					findSubStrings(intermediateState, finalState);
				}
				
			}
			
			intermediateState = initialState;
		}
		
	}
	
	private static int getMax(int[] state) {
		
		if(state[0] >= state[1]) {
			return state[0] >= state[2] ? state[0] : state[2];
		}
		
		return state[1] >= state[2] ? state[1] : state[2];
	}
	
}
