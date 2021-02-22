package grpah;

public class ConnectedComponents {

	public int findCircleNum(int[][] isConnected) {

		int[] parent = new int[isConnected.length];

		init(parent);

		for(int i=0;i<isConnected.length;i++) {
			for(int j=0;j<isConnected[0].length;j++) {

				if(isConnected[i][j] == 1) {
					union(i, j, parent);
				}

			}
		}

		int count = 0;

		for(int num: parent) {

			if(num < 0) {
				count++;
			}

		}

		return count;
	}

	private void init(int[] parent) {

		for(int i=0;i<parent.length;i++) {
			parent[i] = -1;
		}

	}

	private int find(int i, int[] parent) {

		if(parent[i] < 0) {
			return i;
		}

		return find(parent[i], parent);
	}

	private void union(int i, int j, int[] parent) {

		int iParent = find(i, parent);
		int jParent = find(j, parent);

		if(iParent != jParent) {
			int weightIParent = parent[iParent];
			int weightJParent = parent[jParent];

			if(weightIParent > weightJParent) {
				parent[jParent] += parent[iParent];
				parent[iParent] = jParent;
				parent[i] = jParent;
			}
			else {
				parent[iParent] += parent[jParent];
				parent[jParent] = iParent;
				parent[j] = iParent;
			}

		}

	}
	
	public static void main(String[] args) {
		
		int[][] isConnected = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} };
		
		ConnectedComponents solution = new ConnectedComponents();
		solution.findCircleNum(isConnected);
	}

}
