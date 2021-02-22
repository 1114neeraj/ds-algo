package leetcode;

public class TwoCityScheduling {

	public int twoCitySchedCost(int[][] costs) {
        int[] load = new int[2];
        int minCost = 0;
        return calculateLoadBalanceCost(costs, costs.length-1, load, minCost);
    }
    
    public int calculateLoadBalanceCost(int[][] costs, int idx, int[] load, int minCost) {
        
        int totalRequests = costs.length;
        
        if(idx < 0) {
            return minCost;
        }
        
        int costWhenRoutedToA = Integer.MAX_VALUE;
        
        if(load[0] < totalRequests/2) {
            costWhenRoutedToA = calculateLoadBalanceCost(costs, idx-1, load, minCost) + costs[idx][0]; 
        }
        
        int costWhenRoutedToB = Integer.MAX_VALUE;
        
        if(load[1] < totalRequests/2) {
            costWhenRoutedToB = calculateLoadBalanceCost(costs, idx-1, load, minCost) + costs[idx][1]; 
        }
        
        if(costWhenRoutedToA < costWhenRoutedToB) {
            minCost = costWhenRoutedToA;
            load[0] = load[0] + 1;
        }
        else {
            minCost = costWhenRoutedToB;
            load[1] = load[1] + 1;
        }
        
        return minCost;
    }
    
    public static void main(String[] args) {
		TwoCityScheduling obj = new TwoCityScheduling();
		int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
		System.out.println(obj.twoCitySchedCost(costs));
	}
	
}
