package cc.june20b.simulator.guessMatrix;

public class Player implements Runnable {
	
	private PlayerStrategy playerStrategy;
	private Scorer scorer;
	
	public Player(PlayerStrategy playerStrategy, Scorer scorer) {
		this.playerStrategy = playerStrategy;
		this.scorer = scorer;
	}

	@Override
	public void run() {
		try {
			this.process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void process() throws InterruptedException {
		this.playerStrategy.play();
		System.out.println(String.format("For %s queries asked %s and score is %s",
				this.playerStrategy, this.scorer.getQueriesAsked(), this.scorer.getScore()));
	}
	
	
}
