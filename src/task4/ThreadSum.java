package task4;

public class ThreadSum extends Thread {
	
	private int[][] lowerArray;
	private int[] vectorX = new int[3];
	private int sum;
	
	public ThreadSum(int[][] lowerArray) {
		super();
		this.lowerArray = lowerArray;
	}

	public void run() {
		try {
			for(int i = 0; i < vectorX.length; i++) {
				startWait();
				sum = 0;
				if(i > 0)
					for(int j = 0; j < vectorX.length; j++)
						sum = sum + (lowerArray[i][j]*vectorX[j]);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void setVectorX(int[] vectorX) {
		this.vectorX = vectorX;
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
