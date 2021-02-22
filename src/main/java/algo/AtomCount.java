package algo;

import java.util.Map;
import java.util.TreeMap;

public class AtomCount {

	public String countOfAtoms(String formula) {
        Map<String, Integer> countMap = new TreeMap<>();
        char[] array = formula.toCharArray();
        
        int sIdx = -1;
        
        for(int i=0;i<array.length;i++) {
        	if(array[i] == '(') {
        		sIdx = i;
        	}
        	else if(array[i] == ')') {
        		solve(array, sIdx, i-1, countMap);
        	}
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(Map.Entry<String, Integer> entry: countMap.entrySet()) {
        	
        	String str = entry.getKey();
        	
        	if(entry.getValue() != 1 && entry.getValue() != 0) {
        		str += entry.getValue();
        	}
        	
            builder.append(str);
        }
        
        return builder.toString();
    }
    
    private void solve(char[] array, int sIdx, int eIdx, Map<String, Integer> countMap) {
        
        boolean isFound = false;
        
        StringBuilder builder = null;
        int count = 0;
        
        for(int i=sIdx;i<eIdx;i++) {
            
            if(Character.isUpperCase(array[i])) {
                
                if(isFound) {
                   update(countMap, builder.toString(), count);
                   count = 0; 
                }
                
                builder = new StringBuilder();
                builder.append(array[i]);
            }
            else if(Character.isLowerCase(array[i])) {
                builder.append(array[i]);
            }
            else {
                count += array[i] - '0';
                isFound = true;
            }
            
        }
        
        update(countMap, builder.toString(), count);
        
    }
    
    private void update(Map<String, Integer> countMap, String symbol, int count) {
        
        if(countMap.containsKey(symbol)) {
            countMap.put(symbol, countMap.get(symbol) + count);
        }
        else {
            countMap.put(symbol, count);
        }
        
    }
    
    public static void main(String[] args) {
		
    	AtomCount obj = new AtomCount();
    	System.out.println(obj.countOfAtoms("H2O"));
    	
	}
    
	
}
