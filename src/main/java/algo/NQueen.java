package algo;

public class NQueen {
	
	private static void print(int[][] chess) {
		
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess[0].length;j++) {
				System.out.print(chess[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	private static boolean canPlace(int[][] chess, int rowIdx, int colIdx) {
		
		int i,j;
		
		for(i=0;i<colIdx;i++) {
			
			if(chess[rowIdx][i] == 1) {
				return false;
			}
			
		}
		
		for (i = rowIdx, j = colIdx; i >= 0 && j >= 0; i--, j--) {
			
			if (chess[i][j] == 1) {
	        	return false;
	        }
			
		}
	        
	    for (i = rowIdx, j = colIdx; j >= 0 && i < chess.length; i++, j--) {
	    	if(chess[i][j] == 1) {
	    		return false;
	    	}
	    }
	   
	    return true; 
		
	}

	private static boolean solve(int[][] chess, int colIdx) {
		
		if(colIdx == chess[0].length) {
			print(chess);
			System.out.println();
			return true;
		}
		
		boolean res = false;
		
		for(int i=0;i<chess.length;i++) {
			
			if(canPlace(chess, i, colIdx)) {
				
				chess[i][colIdx] = 1;
				
				res = solve(chess, colIdx + 1) || res;

				chess[i][colIdx] = 0;
			}
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int n = 4;
		
		int[][] chess = new int[n][n];
		
		solve(chess, 0);
		
	}
	
}
