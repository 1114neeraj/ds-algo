package grpah;

public class DisjointSet {

	private int size;
	private int[] parent = null;
	
	private DisjointSet(int n) {
		this.size = n;
		this.init();
	}
	
	private void init() {
		this.parent = new int[this.size];
		
		for(int i=0;i<this.size;i++) {
			this.parent[i] = -1;
		}
		
	}
	
	public int find(int i) {
		
		if(parent[i] < 0) {
			return i;
		}
		
		return find(parent[i]);
	}
	
	public void union(int i, int j) {
		
		int parentOfI = find(i);
		int parentOfJ = find(j);
		
		if(parentOfI != parentOfJ) {
			int weightOfParentOfI = this.parent[parentOfI];
			int weightOfParentOfJ = this.parent[parentOfJ];
			
			if(weightOfParentOfI > weightOfParentOfJ) {
				this.parent[parentOfJ] += this.parent[parentOfI]; 
				this.parent[parentOfI] = parentOfJ;
				this.parent[i] = parentOfJ;
			}
			else {
				this.parent[parentOfI] += this.parent[parentOfJ];
				this.parent[parentOfJ] = parentOfI;
				this.parent[j] = parentOfI;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		DisjointSet djs = new DisjointSet(4);
		
		djs.union(0, 1);
		djs.union(1, 2);
		djs.union(2, 3);
		
		for(int num: djs.parent) {
			System.out.print(num+" ");
		}
		
	}
	
}
