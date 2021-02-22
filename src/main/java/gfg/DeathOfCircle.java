package gfg;

public class DeathOfCircle {
	
	private static void solve(int[] array, int k) {
		
		k--;
		
		int size = array.length - 1;
		int counter = 0;
		
		while(counter <= size) {
			
			int temp = k;
			
			while(array[temp] != 1) {
				temp++;
			}
			
			array[temp] = 1;
			
			counter++;
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
