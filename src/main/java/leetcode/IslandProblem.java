package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class IslandProblem {

    public int numIslands(char[][] grid) {
    	int noOfIslands = 0;
    	
    	Set<Vertex> visitedVertices = new HashSet<>();
    	
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			
    			Vertex v = new Vertex(i, j); 
    			
    			if(grid[v.x][v.y] == '1' && !visitedVertices.contains(v)) {
    				dfs(grid, v, visitedVertices);
    				noOfIslands++;
    	    	}
    			
    		}
    	}
    	
    	return noOfIslands;
    }
    
    private static class Vertex {
    	int x;
    	int y;
    	
    	public Vertex(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + "]";
		}
		
    }
    
    private void dfs(char[][] grid, Vertex v, Set<Vertex> visitedVertices) {
    	
    	Stack<Vertex> stack = new Stack<>();
    	stack.add(v);
    	
    	List<Vertex> adjacencyVertics = null;
    	
    	visitedVertices.add(v);
    	
    	while(!stack.isEmpty()) {
    		
    		Vertex poppedVertex = stack.pop();
    		
    		adjacencyVertics = getAdjacencyVertices(grid, poppedVertex);
    		
    		for(Vertex adjacencyVertex : adjacencyVertics) {
    			
    			if(!visitedVertices.contains(adjacencyVertex)) {
    				visitedVertices.add(adjacencyVertex);
    				stack.add(adjacencyVertex);
    			}
    			
    		}
    		
    	}
    	 
    }
    
    private List<Vertex> getAdjacencyVertices(char[][]grid, Vertex v) {
    	List<Vertex> adjacencyVertics = new ArrayList<>();
    	
    	if(v.x > 0 && grid[v.x-1][v.y] == '1') {
    		adjacencyVertics.add(new Vertex(v.x - 1, v.y));
    	}
    	
    	if(v.x < grid.length - 1 && grid[v.x+1][v.y] == '1') {
    		adjacencyVertics.add(new Vertex(v.x + 1, v.y));
    	}
    	
    	if(v.y > 0 && grid[v.x][v.y-1] == '1') {
    		adjacencyVertics.add(new Vertex(v.x, v.y - 1));
    	}
    	
    	if(v.y < grid[0].length - 1 && grid[v.x][v.y+1] == '1') {
    		adjacencyVertics.add(new Vertex(v.x, v.y + 1));
    	}
    	
    	return adjacencyVertics;
    }
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	
    	int count = 0;
    	List<String> inputs = new ArrayList<>();
    	
    	while(true) {
    		String input = scanner.nextLine();
    		
    		if(input.equalsIgnoreCase("")) {
    			break;
    		}
    		
    		inputs.add(input);
    		count++;
    	}
    	
    	char[][] grid = new char[count][inputs.get(0).length()];
    	
    	int i = 0;
    	
    	for(String input : inputs) {
    		
    		char[] temp = input.toCharArray();
    		
    		for(int j=0;j<temp.length;j++) {
    			grid[i][j] = temp[j];
    		}
    		
    		i++;
    		
    	}
    	
    	IslandProblem obj = new IslandProblem();
    	System.out.println(obj.numIslands(grid));
    	
    	scanner.close();
	}
    
}
