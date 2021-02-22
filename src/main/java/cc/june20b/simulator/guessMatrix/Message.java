package cc.june20b.simulator.guessMatrix;

public class Message {

	private int sizeOfMatrix;
	private int count;
	
	private int actionFlag;
	
	private int r1;
	private int c1;
	private int r2;
	private int c2;
	
	private int[][] matrix;
	
	public Message(int sizeOfMatrix, int count, int actionFlag, int r1, int c1, int r2, int c2, int[][] matrix) {
		this.sizeOfMatrix = sizeOfMatrix;
		this.count = count;
		this.actionFlag = actionFlag;
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
		this.matrix = matrix;
	}

	public int getSizeOfMatrix() {
		return sizeOfMatrix;
	}

	public void setSizeOfMatrix(int sizeOfMatrix) {
		this.sizeOfMatrix = sizeOfMatrix;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(int actionFlag) {
		this.actionFlag = actionFlag;
	}

	public int getR1() {
		return r1;
	}

	public void setR1(int r1) {
		this.r1 = r1;
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getR2() {
		return r2;
	}

	public void setR2(int r2) {
		this.r2 = r2;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
}
