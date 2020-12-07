package task4;

public class ThreadSum extends Thread {
	
	public void run() {
		
	}
	
	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}

}
