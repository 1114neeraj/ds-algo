package thread;

public class H2O {

	private int hCounter = 0;
	private int oCounter = 0;
	
	public H2O() {
		
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
		synchronized (this) {
			
			while(hCounter > 2*oCounter) {
				this.wait();
			}
			
			// releaseHydrogen.run() outputs "H". Do not change or remove this line.
			releaseHydrogen.run();
			hCounter++;
			this.notifyAll();
			
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		
		synchronized (this) {
			
			while(2*oCounter > hCounter) {
				this.wait();
			}
			
			// releaseOxygen.run() outputs "O". Do not change or remove this line.
			releaseOxygen.run();
			oCounter++;
			this.notifyAll();
		}
		
	}

}
