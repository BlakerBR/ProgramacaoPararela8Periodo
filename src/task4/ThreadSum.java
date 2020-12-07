package task4;

public class ThreadSum extends Thread {
	
	private int[][] lowerArray;
	private int[] vectorB;
	private int sum = 0;
	
	public ThreadSum(int[][] lowerArray, int[] vectorB) {
		super();
		this.lowerArray = lowerArray;
		this.vectorB = vectorB;
	}

	public void run() {
		try {
			for(int i = 0; i < vectorB.length; i++) {
				if(i > 0)
					/*for(int j = 0; j < vectorB.length; j++)
						sum = sum + (lowerArray[i][j]*);*/
				
				startWait();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized int getSum() {
		return sum;
	}
	
	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}

}
