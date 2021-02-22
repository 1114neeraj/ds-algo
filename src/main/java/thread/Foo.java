package thread;

class Foo {

	private boolean isFirstDone = false;
	private boolean isSecondDone = false;
	
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
        	
        	// printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            isFirstDone = true;
            this.notifyAll();
        	
		}
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
    	synchronized (this) {
			
    		while(!isFirstDone) {
    			this.wait();
    		}
    		
    		// printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecondDone = true;
            this.notifyAll();
    		
		}
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
    	synchronized (this) {
			
    		while(!isSecondDone) {
    			this.wait();
    		}
    		
    		// printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
		}
        
    }
}