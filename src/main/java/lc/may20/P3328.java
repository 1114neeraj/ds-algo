package lc.may20;

public class P3328 {

    public String removeKdigits(String num, int k) {
        
    	StringBuilder builder = new StringBuilder();
    	
    	char[] array = num.toCharArray();
    	int chosenIdx = 0;
    	
    	for(int i=0;i<array.length - k;i++) {
    		
    		int minValue = Integer.MAX_VALUE;
    		int j = chosenIdx>=i?chosenIdx + 1:i;
    		
    		for(;j<i+k+1;j++) {
    			
    			int value = array[j] - '0';
    			
    			if(value < minValue) {
    				minValue = value;
    				chosenIdx = j;
    			}
    			
    		}
    		
    		builder.append(array[chosenIdx]);
    		
    	}
    	
    	return builder.toString();
    }
	
    public static void main(String[] args) {
		P3328 obj = new P3328();
		System.out.println(obj.removeKdigits("1432219", 3));
	}
}
