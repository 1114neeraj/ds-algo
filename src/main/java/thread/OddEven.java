package thread;

public class OddEven {

	private static class PrintNumber implements Runnable {

		private boolean isEven;
		
		private Integer counter = 1;
		
		public PrintNumber(boolean isEven) {
			this.isEven = isEven;
		}
		
		@Override
		public void run() {
			
			while(counter < 10) {

				if(isEven) {
					printEven();
				}
				else {
					printOdd();
				}

			}

		}
		
		private void printOdd() {
			
			System.out.println(isEven);
			
			synchronized (this) {
				System.out.println("inside odd sync");
				while(counter % 2 == 0) {
					System.out.println("inside odd condition");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(counter);
				counter++;
				System.out.println(counter);
				this.notifyAll();
			}

		}
		
		private void printEven() {
			
			System.out.println(isEven);
			
			synchronized (this) {
				System.out.println("inside even sync");
				while(counter % 2 != 0) {
					System.out.println("inside even condition");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(counter);
				counter++;
				System.out.println(counter);
				this.notifyAll();
			}
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new PrintNumber(true));
		t1.start();
		
		Thread t2 = new Thread(new PrintNumber(false));
		t2.start();
		
	}
	
}
