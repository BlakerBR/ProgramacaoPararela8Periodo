package task4;

public class ThreadSum extends Thread {
	
	private int[][] lowerArray;
	private int[] vectorB;
	private int[] vectorX = new int[3];
	private int sum;
	
	public ThreadSum(int[][] lowerArray, int[] vectorB) {
		super();
		this.lowerArray = lowerArray;
		this.vectorB = vectorB;
	}

	public void run() {
		try {
			for(int i = 0; i < vectorB.length; i++) {
				startWait();
				sum = 0;
				if(i > 0)
					for(int j = 0; j < vectorB.length; j++)
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
