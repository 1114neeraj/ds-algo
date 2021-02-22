package cc.june20b.simulator.guessMatrix;

public class Scorer {

	private int queriesAsked = 0;
	private int score = 0;
	
	public Scorer() {}
	
	public void calculateScore(int n, int r1, int c1, int r2, int c2, int count) {
		this.queriesAsked++;
		score += (int)Math.ceil( ((2*n - (r2-r1+1)) * (2*n - (c2-c1+1))) / (1+count));
	}

	public int getQueriesAsked() {
		return queriesAsked;
	}

	public void setQueriesAsked(int queriesAsked) {
		this.queriesAsked = queriesAsked;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
