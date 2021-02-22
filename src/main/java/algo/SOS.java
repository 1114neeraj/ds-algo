package algo;

public class SOS {

	public static void main(String[] args) {
		int[] initialState = {1, 2, 3};
		int[] finalState = {1, 4, 4};
		System.out.println("count is " + solve(initialState, finalState));
	}
	
	private static int solve(int[] initialState, int[] finalState) {

		if(isGreater(initialState, finalState)) {
			return 0;
		}
		else if(isEqual(initialState, finalState)) {
			return 1;
		}

		int n = (int)Math.pow(2, initialState.length);
		
		int count = 0;
		
		int[] intermediateState = new int[initialState.length];
		
		for(int k=1;k<=5;k++) {
			
			for(int i=1;i<n;i++) {
				
				copy(initialState, intermediateState);
				
				int mask = 1;

				for(int j=0;j<initialState.length;j++) {

					if((i & mask) > 0) {
						intermediateState[j] = initialState[j] + k;
					}
					else {
						intermediateState[j] = initialState[j];
					}

					mask = mask << 1;

				}

//				System.out.println(String.format("%s %s %s", intermediateState[0],
//						intermediateState[1], intermediateState[2]));
				
				if(solve(intermediateState, finalState) == 1) {
					count++;
				}

			}
			
		}

		return count;
	}
	
	private static boolean isEqual(int[] stateA, int[] stateB) {
		
		if(stateA[0] == stateB[0] && stateA[1] == stateB[1] &&
				stateA[2] == stateB[2]) {
			return true;
		}
		return false;
	}
	
	private static boolean isGreater(int[] stateA, int[] stateB) {
		
		if(stateA[0] > stateB[0] || stateA[1] > stateB[1] || stateA[2] > stateB[2]) {
			return true;
		}
		
		return false;
	}
	
	private static void copy(int[] stateA, int[] stateB) {
		
		for(int i=0;i<stateA.length;i++) {
			stateB[i] = stateA[i];
		}
		
	}
}
