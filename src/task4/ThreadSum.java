package task4;

public class ThreadSum extends Thread {
	
	private float[][] lowerArray;
	private float[] vectorX = new float[3];
	private float sum;
	
	public ThreadSum(float[][] lowerArray) {
		super();
		this.lowerArray = lowerArray;
	}

	public void run() {
		try {
			for(int i = 0; i < vectorX.length; i++) {
				startWait();
				sum = 0;
				for(int j = 0; j < i; j++)
					sum = sum + (lowerArray[i][j]*vectorX[j]);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void setVectorX(float[] vectorX) {
		this.vectorX = vectorX;
	}
	
	public synchronized float getSum() {
		return sum;
	}
	
	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}

}
