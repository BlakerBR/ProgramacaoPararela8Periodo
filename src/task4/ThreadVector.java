package task4;

public class ThreadVector extends Thread {
	
	private float[][] lowerArray;
	private float[] vectorB;
	private float[] vectorX = new float[3];
	private float sum;
	
	public ThreadVector(float[][] lowerArray, float[] vectorB) {
		super();
		this.lowerArray = lowerArray;
		this.vectorB = vectorB;
	}
	
	public void run() {
		try {
			for(int i = 0; i < vectorX.length; i++) {
				startWait();
				vectorX[i] = (vectorB[i] - sum)/lowerArray[i][i];
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public synchronized float[] getVectorX() {
		return vectorX;
	}

	public synchronized void setSum(float sum) {
		this.sum = sum;
	}

	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}

}
