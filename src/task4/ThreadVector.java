package task4;

public class ThreadVector extends Thread {
	
	private int[][] lowerArray;
	private int[] vectorB;
	private int[] vectorX = new int[3];
	private int sum;
	
	public ThreadVector(int[][] lowerArray, int[] vectorB) {
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
	
	public int[] getVectorX() {
		return vectorX;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}

}
